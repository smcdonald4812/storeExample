import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Navbar, Nav, Form, FormControl, Button} from 'react-bootstrap';
import Home from './home.js';
import News from './news.js';
import Account from './account.js';
import Cart from './cart.js';
import ItemService from '../services/itemService.js';
import Login from './login.js';

class NavBar extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            isHome:true,
            isAccount:false,
            isNews:false,
            isCart:false,
            isItem:false,
            login:false,
            search:'',
            user:[],
            cart:[],
            items:[]
        }
        this.home = this.home.bind(this);
        this.account = this.account.bind(this);
        this.news = this.news.bind(this);
        this.cart = this.cart.bind(this);
        this.search = this.search.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.login = this.login.bind(this);
    }
    handleChange(event) {
        const value = event.target.value;
        const name = event.target.name;
        this.setState({
            [name]: value
        });
    }
    home() {
        this.setState({
            isHome:true,
            isAccount:false,
            isNews:false,
            isItem:false,
            isCart:false,
            login:false,
            isSearch:false
        });
    }
    account() {
        this.setState({
            isHome:false,
            isAccount:true,
            isNews:false,
            isItem:false,
            isCart:false,
            login:false,
            isSearch:false
        });
    }
    news() {
        this.setState({
            isHome:false,
            isAccount:false,
            isNews:true,
            isItem:false,
            isCart:false,
            login:false,
            isSearch:false
        });
    }
    cart() {
        this.setState({
            isHome:false,
            isAccount:false,
            isNews:false,
            isItem:false,
            isCart:true,
            login:false,
            isSearch:false
        });
    }
    item() {
        this.setState({
            isHome:false,
            isAccount:false,
            isNews:false,
            isItem:true,
            isCart:false,
            login:false,
            isSearch:false
        });
    }
    search() {
        this.setState({
            isHome:false,
            isAccount:false,
            isNews:false,
            isItem:false,
            isCart:false,
            login:false,
            isSearch: true
        });
    }
    login() {
        this.setState({
            isHome:false,
            isAccount:false,
            isNews:false,
            isItem:false,
            isCart:false,
            login:true,
            isSearch: false
        });
    }
    searching(event) {
        event.preventDefault();
        if(this.state.search.length>0) {
            ItemService.getSearch(this.state.search).then((response)=> {
                this.setState({items:response.data});
            });
            this.search();
        }
        event.stopPropigation();
    }
    render() {
        if(this.props.justLogged!==undefined) {
            this.setState({
                user:this.props.user,
                cart:this.props.cart
            });
        }
        let page;
                if(this.state.isHome===true) {
                    page = <Home user={this.state.user} cart={this.state.cart}/>;
                } else if(this.state.isAccount===true) {
                    page = <Account user={this.state.user} cart={this.state.cart}/>;
                } else if(this.state.isNews===true) {
                    page = <News user={this.state.user} cart={this.state.cart}/>;
                } else if(this.state.isCart===true) {
                    page = <Cart user={this.state.user} cart={this.state.cart}/>;
                } else if(this.state.isSearch===true) {
                    page = <Home user={this.state.user} cart={this.state.cart} items={this.state.items}/>;
                } else if(this.state.login===true) {
                    page = <Login user={this.state.user} cart={this.state.cart}/>;
                }
        return  ( <div>
            <Navbar fixed="top" bg="dark" expand="lg">
                <Navbar.Brand className="text-light" onClick={this.home}>Example Store</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link className="text-light" onClick={this.home}>Home</Nav.Link>
                        <Nav.Link className="text-light" onClick={this.news}>News</Nav.Link>
                        <Nav.Link className="text-light" onClick={this.account}>Account</Nav.Link>
                        <Nav.Link className="text-light" onClick={this.cart}>Cart</Nav.Link>
                        <Nav.Link className="text-light" onClick={this.login}>Login</Nav.Link>
                    </Nav>
                    <Form inline>
                    <FormControl type="text" name="search" value={this.state.search} placeholder="Search" onChange={this.handleChange} className="mr-sm-2" />
                    <Button variant="outline-success" onClick={this.searching}>Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Navbar>
            {page}
            </div>
        );
    }
}

export default NavBar;