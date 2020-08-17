import axios from 'axios'

const ITEMTRANSACTION_REST_API_GETALL_URL = 'http://localhost:8080/storeexample/itemtransaction/get';
const ITEMTRANSACTION_REST_API_PUT_URL = 'http://localhost:8080/storeexample/itemtransaction/update';
const ITEMTRANSACTION_REST_API_POST_URL = 'http://localhost:8080/storeexample/itemtransaction/create';

class ItemTransactionService {
    getAll(id) {
        let s = ITEMTRANSACTION_REST_API_GETALL_URL+'/'+id;
        return axios.get(s);
    }
    put(i) {
        let itemtrans = JSON.stringify(i);
        return axios.put(ITEMTRANSACTION_REST_API_PUT_URL, itemtrans, {headers:{'content-type':'application/json'}});
    }
    post(i) {
        let itemtrans = JSON.stringify(i);
        return axios.post(ITEMTRANSACTION_REST_API_POST_URL, itemtrans, {headers:{'content-type':'application/json'}});
    }
}

export default new ItemTransactionService();