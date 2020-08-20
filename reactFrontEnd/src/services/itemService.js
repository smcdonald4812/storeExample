import axios from 'axios'

const ITEM_REST_API_GET_URL = 'http://localhost:8080/storeexample/mongo/readId';
const ITEM_REST_API_GETSEARCH_URL = 'http://localhost:8080/storeexample/mongo/readTitle';
const ITEM_REST_API_GETTYPE_URL = 'http://localhost:8080/storeexample/mongo/readType';
const ITEMS_REST_API_GETALL_URL = 'http://localhost:8080/storeexample/mongo/';
const ITEM_REST_API_PUT_URL = 'http://localhost:8080/storeexample/mongo/update';
const ITEM_REST_API_POST_URL = 'http://localhost:8080/storeexample/mongo/create';
const ITEM_REST_API_DELETE_URL = 'http://localhost:8080/storeexample/mongo/delete';

class ItemService {
    get(id) {
        let s = ITEM_REST_API_GET_URL+'/'+id;
        return axios.get(s);
    }
    getAll() {
        return axios.get(ITEMS_REST_API_GETALL_URL);
    }
    getType(type) {
        let s = ITEM_REST_API_GETTYPE_URL+'/'+type;
        return axios.get(s);
    }
    getSearch(str) {
        let s = ITEM_REST_API_GETSEARCH_URL+'/'+str;
        return axios.get(s);
    }
    put(i) {
        let item = JSON.stringify(i);
        return axios.put(ITEM_REST_API_PUT_URL, item, {headers:{'content-type':'application/json'}});
    }
    post(i) {
        let item = JSON.stringify(i);
        return axios.post(ITEM_REST_API_POST_URL, item, {headers:{'content-type':'application/json'}});
    }
    delete(id) {
        let s = ITEM_REST_API_DELETE_URL+'/'+id;
        return axios.delete(s);
    }
}

export default new ItemService();