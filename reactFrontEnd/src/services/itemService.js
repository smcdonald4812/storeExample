import axios from 'axios'

const ITEM_REST_API_GET_URL = 'http://localhost:8080/storeexmple/mongo/readItem';
const ITEMS_REST_API_GET_URL = 'http://localhost:8080/storeexmple/mongo/readItems';
const ITEM_REST_API_PUT_URL = 'http://localhost:8080/storeexmple/mongo/updateItem';
const ITEM_REST_API_POST_URL = 'http://localhost:8080/storeexmple/mongo/createItem';
const ITEM_REST_API_DELETE_URL = 'http://localhost:8080/storeexmple/mongo/deleteItem';

class itemService {
    readItem(){
        return axios.get(ITEM_REST_API_GET_URL);
    }
    readItems(){
        return axios.get(ITEMS_REST_API_GET_URL);
    }
    updateItem() {
        return axios.put(ITEM_REST_API_PUT_URL);
    }
    createItem() {
        return axios.post(ITEM_REST_API_POST_URL);
    }
    deleteItem() {
        return axios.delete(ITEM_REST_API_DELETE_URL);
    }
}

export default new itemService();