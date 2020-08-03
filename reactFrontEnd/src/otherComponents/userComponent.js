import React from 'react';
import userService from '../services/userService';

class userComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            user:[]
        }
    }

    componentDidMount(){
        userService.readUser().then((response) => {
            this.setState({ user: response.data})
        });
    }

    render (){
        return (
            <div>
                {
                            this.state.user.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.id}</td>   
                                     <td> {user.firstName}</td>   
                                     <td> {user.lastName}</td>   
                                     <td> {user.email}</td>   
                                </tr>
                            )
                        }
            </div>

        )
    }
}

export default userComponent