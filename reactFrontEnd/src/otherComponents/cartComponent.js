import React from 'react';
import cartService from '../services/cartService';

class itemComponent extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            cart:[]
        }
    }

    componentDidMount() {
        cartService.readCart().then((response) => {
            this.setState({ cart: response.data})
        });
    }

    itemList() {
        return this.state.cart;
    }

    render() {
        return (
            <div>
                {
                    this.state.cart.map(
                                i => 
                                <div key = {i.id}>
                                     <div> {i.id}</div>   
                                     <div> {i.name}</div>   
                                     <div> {i.items}</div>   
                                     <div> {i.total}</div>   
                                </div>
                            )
                    }
            </div>
        );
    }
}

export default itemComponent;