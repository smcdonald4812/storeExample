import axios from 'axios'

const ACCOUNTTRANSACTION_REST_API_GETALL_URL = 'http://localhost:8080/storeexample/accounttransaction/get';
const ACCOUNTTRANSACTION_REST_API_PUT_URL = 'http://localhost:8080/storeexample/accounttransaction/update';
const ACCOUNTTRANSACTION_REST_API_POST_URL = 'http://localhost:8080/storeexample/accounttransaction/create';

class AccountTransactionService {
    getAll(id) {
        let s = ACCOUNTTRANSACTION_REST_API_GETALL_URL+'/'+id;
        return axios.get(s);
    }
    put(a) {
        let accounttrans = JSON.stringify(a);
        return axios.put(ACCOUNTTRANSACTION_REST_API_PUT_URL, accounttrans, {headers:{'content-type':'application/json'}});
    }
    post(a) {
        let accounttrans = JSON.stringify(a);
        return axios.post(ACCOUNTTRANSACTION_REST_API_POST_URL, accounttrans, {headers:{'content-type':'application/json'}});
    }
}

export default new AccountTransactionService();