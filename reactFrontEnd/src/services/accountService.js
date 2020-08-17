import axios from 'axios'

const ACCOUNT_REST_API_GETALL_URL = 'http://localhost:8080/storeexample/account/get';
const ACCOUNT_REST_API_PUT_URL = 'http://localhost:8080/storeexample/account/update';
const ACCOUNT_REST_API_POST_URL = 'http://localhost:8080/storeexample/account/create';

class AccountService {
    getAll(id) {
        let s = ACCOUNT_REST_API_GETALL_URL+'/'+id;
        return axios.get(s);
    }
    put(a) {
        let account = JSON.stringify(a);
        return axios.put(ACCOUNT_REST_API_PUT_URL, account, {headers:{'content-type':'application/json'}});
    }
    post(a) {
        let account = JSON.stringify(a);
        return axios.post(ACCOUNT_REST_API_POST_URL, account, {headers:{'content-type':'application/json'}});
    }
}

export default new AccountService();