import axios from 'axios'

const USER_REST_API_GET_URL = 'http://localhost:8080/storeexmple/h2/readUser';
const USERS_REST_API_PUT_URL = 'http://localhost:8080/storeexmple/h2/updateUser';
const USERS_REST_API_POST_URL = 'http://localhost:8080/storeexmple/h2/createUser';
const USERS_REST_API_DELETE_URL = 'http://localhost:8080/storeexmple/h2/deleteUser';

class userService {
    readUser(){
        return axios.get(USER_REST_API_GET_URL);
    }
    updateUser() {
        return axios.put(USERS_REST_API_PUT_URL);
    }
    createUser() {
        return axios.post(USERS_REST_API_POST_URL);
    }
    deleteUser() {
        return axios.delete(USERS_REST_API_DELETE_URL);
    }
}

export default new userService();