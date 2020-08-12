import axios from 'axios'

const CART_REST_API_GET_URL = 'http://localhost:8080/storeexmple/cart';
const CART_REST_API_PUT_URL = 'http://localhost:8080/storeexmple/cart/update';
const CART_REST_API_POST_URL = 'http://localhost:8080/storeexmple/cart/create';
const CART_REST_API_DELETE_URL = 'http://localhost:8080/storeexmple/cart/delete';

class CartService {
    get(username){
        let s = CART_REST_API_GET_URL+'/'+username;
        return axios.get(s);
    }
    put(c) {
        let cart = JSON.stringify(c);
        return axios.put(CART_REST_API_PUT_URL, cart, {headers:{'content-type':'application/json'}});
    }
    post(c) {
        let cart = JSON.stringify(c);
        return axios.post(CART_REST_API_POST_URL, cart, {headers:{'content-type':'application/json'}});
    }
    delete(id) {
        let s = CART_REST_API_DELETE_URL+'/'+id;
        return axios.delete(s);
    }
}

export default new CartService();