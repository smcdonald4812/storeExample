import axios from 'axios';

const MEMBERSHIPTIERS_REST_API_GETALL_URL = 'http://localhost:8080/storeexample/itemtransaction/getall';

class MembershipTiersService {
    getAll() {
        axios.get(MEMBERSHIPTIERS_REST_API_GETALL_URL);
    }
}
export default MembershipTiersService();