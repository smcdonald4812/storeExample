import React from 'react';
import Purchase from './purchase.js';
import {Button} from 'react-bootstrap';

class Cart extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            user:this.props.user,
            cart:this.props.cart,
            item:this.props.item,
            total:0.0,
            isPurchase:false
        }
        this.finalizePurchases = this.finalizePurchases.bind(this);
        this.loadCart = this.loadCart.bind(this);
    }
    finalizePurchases(event) {
        event.preventDefault();
        this.setState({isPurchase:true});
        event.stopPropigation();
    }
    loadCart() {
        let sum = 0.0;
        let tableData = [];
        if(this.state.item!==undefined) {
            this.state.cart.push(this.state.item);
        }
        tableData.push(
            <tr key={this.state.user.username}>
                <td>Cart</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        );
        for(let i = 0; i < this.state.cart.length; i++) {
            sum+=this.state.cart[i].total;
            tableData.push(
                <tr key={this.state.cart[i].id}>
                    <td><img src={this.state.cart[i].imgURL} alt={this.state.cart[i].altText}/></td>
                    <td>{this.state.cart[i].title}</td>
                    <td>{this.state.cart[i].price}</td>
                    <td></td>
                </tr>
            );
        }
        this.setState({total:sum});
        tableData.push(
            <tr key={this.state.total}>
                <td>Total</td>
                <td></td>
                <td></td>
                <td>{this.state.total}</td>
            </tr>
        );
        tableData.push(
            <tr key={this.state.user.id}>
                <td></td>
                <td></td>
                <td>Purchase</td>
                <td><Button variant="primary" name="Buy" value="Buy" onClick={this.finalizePurchases}/></td>
            </tr>
        );
        return <tbody>{tableData}</tbody>
    }
    render() {
        if(this.state.isPurchase===true) {
            return (
                <Purchase user={this.state.user} total={this.state.total} cart={this.state.cart}/>
            );
        } else {
            return (
                <div className="mr-auto" style={{ marginTop: "100px"}}>
                    <table className="table table-borderless">
                        {this.loadCart}
                    </table>
                </div>
            );
        }
    }
}

export default Cart;