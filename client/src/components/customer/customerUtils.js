import { FilterMatchMode } from 'primereact/api';

export const countriesCodes = [
    {name:'Moroco',value:'Moroco' },
    {name:'Cameroon',value:'Cameroon' },
    {name:'Uganda',value:'Uganda' },
    {name:'Mozambique',value:'Mozambique' },
    {name:'Ethiopia',value:'Ethiopia' },
];
export const phoneStates = [
    {name: 'All', code: 'all'},
    {name: 'Valid', code: 'valid'}
];

export const customerFilters= {
    'name': { value: null, matchMode: FilterMatchMode.STARTS_WITH },
    'phone': { value: null, matchMode: FilterMatchMode.STARTS_WITH },
    'country': { value: null, matchMode: FilterMatchMode.STARTS_WITH }
}