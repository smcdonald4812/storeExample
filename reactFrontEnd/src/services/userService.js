import axios from 'axios'

const USER_REST_API_GET_URL = 'http://localhost:8080/storeexample/user';
const USERS_REST_API_PUT_URL = 'http://localhost:8080/storeexample/user/update';
const USERS_REST_API_POST_URL = 'http://localhost:8080/storeexample/user/create';

class userService {
    get(username, pass){
        let s = USER_REST_API_GET_URL+'/'+username+'/'+pass;
        return axios.get(s);
    }
    put(u) {
        let user = JSON.stringify(u);
        return axios.put(USERS_REST_API_PUT_URL, user, {headers:{'content-type':'application/json'}});
    }
    post(u) {
        let user = JSON.stringify(u);
        return axios.post(USERS_REST_API_POST_URL, user, {headers:{'content-type':'application/json'}});
    }
}

export default new userService();