
const BASE_URL =`http://localhost:8081/api/v1/customer`

export const findAllCustomersPaging = (page, size, sortBy, orderBy ,fillters)=>{
    let url = `${BASE_URL}/find-all-page?page=${page}&size=${size}`;
    
    const body ={
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        
      };
        if(sortBy){
            url =url +`&sort=${sortBy}`;
            if(orderBy){
                url =url+ `,${orderBy > 0 ? 'asc' : 'desc'}`;
            }
        }
        if(fillters){
            let filter = new Map();
            fillters.country.value && filter.set('country', fillters.country.value);
            fillters.phone.value && filter.set('phoneValid', fillters.phone.value);
            var obj = Object.fromEntries(filter);
            body.body = JSON.stringify(obj);
        }
       
        
    return fetch(url,body).then(res => res.json());
}

