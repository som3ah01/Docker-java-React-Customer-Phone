import React, { useEffect, useState } from 'react'
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

import { MultiSelect } from 'primereact/multiselect';
import { SelectButton } from 'primereact/selectbutton';

import {findAllCustomersPaging} from './customerService';
import {countriesCodes, phoneStates , customerFilters} from './customerUtils';


export default function Customer() {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [first, setFirst] = useState(0);
    const [rows] = useState(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [currentSortField, setCurrentSortField] = useState();  
    const [currentSortOrder, setCurrentSortOrder] = useState();   
    const [currentPage, setCurrentPage] = useState(0);
    const [phoneState, setPhoneState] = useState('all'); 
    const [currentFilters, setCurrentFilters] = useState(customerFilters);
    

    useEffect(() => {
        callFindCustomer({});
    }, []);

    const callFindCustomer = ({page=currentPage,sortField= currentSortField, orderBy=currentSortOrder, filters=currentFilters}) =>{
        setLoading(true);
        findAllCustomersPaging(page,rows, sortField, orderBy,filters ).then(data => {
            setCustomers(data.content);
            setTotalRecords(data.totalElements);
            setLoading(false);
        });

    }
    const onSort = (event) =>{
        setCurrentSortField(event.sortField);
        setCurrentSortOrder(event.sortOrder);
        callFindCustomer({sortField:event.sortField, orderBy:event.sortOrder});
    }
    const onPage = (event) =>{
        setFirst(event.first);
        setCurrentPage(event.page);

        callFindCustomer({page:event.page});
    }
    const onFilter = (e)=>{
        setCurrentFilters(e.filters);
        callFindCustomer({filters:e.filters});
    }
    const onFilterClear = (e)=>{
        callFindCustomer({});
    }
   

    const onCounrtyValueChange = (e, options) => {
        options.filterApplyCallback(e.value);
    }
   
    const onPhoneValueChange = (e, options) =>{
        setPhoneState(e.value);
        options.filterApplyCallback(e.value);
    }
    const countryItemTemplate =(option) => {
        return ( <span className="image-text">{option.name}</span> );
    }
    const countryRowFilterTemplate =(options) => {
        return (
                <MultiSelect  optionLabel="name"  value={options.value} options={countriesCodes} itemTemplate={countryItemTemplate} 
                    onChange={ e => onCounrtyValueChange(e, options)} placeholder="Any" className="p-column-filter" maxSelectedLabels={2} />
        );
    }
    const phoneRowFilterTemplate = (options) =>{
        return(
            <SelectButton optionLabel="name" optionValue="code" value={phoneState} options={phoneStates} onChange={e => onPhoneValueChange(e,options)} 
                unselectable={false} />
        );
    }

  return (
        <DataTable value={customers}  paginator rows={rows} totalRecords={totalRecords} 
            onPage={onPage} loading={loading} lazy first={first}
            sortField={currentSortField} sortOrder={currentSortOrder} removableSort onSort={onSort}
            filterDisplay="row" onFilter={onFilter} filters={currentFilters}
            >
            <Column field="id" header="ID" sortable />
            <Column field="name" header="Name" sortable />
            <Column field="phone" header="Phone" sortable filter showFilterMenu={false}
            filterElement={phoneRowFilterTemplate} showClearButton={false} />
            <Column field="country" header="Country" filter showFilterMenu={false}
            filterElement={countryRowFilterTemplate}  onFilterClear={onFilterClear} />
        </DataTable>
  )
}
