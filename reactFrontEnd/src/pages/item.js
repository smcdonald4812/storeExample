import React from 'react';
import {Card, Button} from 'react-bootstrap';
import Cart from './cart.js';
import CartService from '../services/cartService.js';
import Login from './login.js';

class Item extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            item:this.props.item,
            user:this.props.user,
            cart:this.props.cart,
            bought:false,
            loggedIn:true
        }
        this.purchase = this.purchase.bind(this);
        this.login = this.login.bind(this);
    }
    purchase(event) {
        event.preventDefault();
        if(this.state.user===undefined) {
            this.setState({loggedIn:false})
        } else {
            this.setState({bought:true});
            CartService.put(this.state.cart);
        }
        event.stopPropigation();
    }
    load() {
        return (        
            <div key={this.state.item.id}>
                <form onSubmit={this.purchase}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src={this.state.item.imgURL} alt={this.state.item.altText}/>
                        <Card.Body>
                            <Card.Title>{this.state.item.title}</Card.Title>
                            <Card.Text>{this.state.item.description}</Card.Text>
                            <Card.Text>{this.state.item.price}</Card.Text>
                            <Button variant="primary" type="submit" name={this.state.item.id} key={this.state.item.id}>Shop</Button>
                        </Card.Body>
                    </Card>
                </form>
            </div>
        );
    }
    render() {
        if(this.state.bought===true) {
            return(
                <div className="mr-auto" style={{ marginTop: "100px"}}>
                    <Cart user={this.state.user} cart={this.state.cart} item={this.state.item}/>
                </div>
            );
        } else if(this.state.loggedIn===false) {
            return(
                <div>
                    <Login cart={this.state.cart} item={this.state.item}/>
                </div>
            );
        } else {
            return ( 
                <div className="mr-auto" style={{ marginTop: "100px"}}>
                    {this.load()}
                </div>
            );
        }
       
    }
}
export default Item;