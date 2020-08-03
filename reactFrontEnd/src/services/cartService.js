import axios from 'axios'

const CART_REST_API_GET_URL = 'http://localhost:8080/storeexmple/mongo/readCart';
const CART_REST_API_PUT_URL = 'http://localhost:8080/storeexmple/mongo/updateCart';
const CART_REST_API_POST_URL = 'http://localhost:8080/storeexmple/mongo/createCart';
const CART_REST_API_DELETE_URL = 'http://localhost:8080/storeexmple/mongo/deleteCart';

class cartService {
    readCart(){
        return axios.get(CART_REST_API_GET_URL);
    }
    updateCart() {
        return axios.put(CART_REST_API_PUT_URL);
    }
    createCart() {
        return axios.post(CART_REST_API_POST_URL);
    }
    deleteCart() {
        return axios.delete(CART_REST_API_DELETE_URL);
    }
}

export default new cartService();