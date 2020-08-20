import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Navbar, Nav, Form, FormControl, Button, Container, Row, Col} from 'react-bootstrap';
import Home from './home.js';
import News from './news.js';
import Account from './account.js';
import Cart from './cart.js';
import ItemService from '../services/itemService.js';
import UserService from '../services/userService.js';

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
            flag:false,
            signUp:false,
            search:'',
            user:[],
            cart:[],
            items:[],
            firstname:'',
            lastname:'',
            username:'',
            password:'',
            country:'',
            mobile:'',
            pass2:'',
            pass:'',
            uName:''
        }
        this.home = this.home.bind(this);
        this.account = this.account.bind(this);
        this.news = this.news.bind(this);
        this.cart = this.cart.bind(this);
        this.search = this.search.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.login = this.login.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleSubmitSignUp = this.handleSubmitSignUp.bind(this);
        this.goTo = this.goTo.bind(this);
        this.signUp = this.signUp.bind(this);
        this.verifyUser = this.verifyUser.bind(this);
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
    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state.uName+" "+this.state.pass);
        if(this.state.uName!=='' & this.state.pass!=='') {
            UserService.get(this.state.uName, this.state.pass).then((response) => {
                this.setState({ user: response.data});
            });
            if(this.state.user.username===undefined) {
                alert('User name or password is invalid');
            } else {
                this.home();
            }
        }
        event.stopPropagation();
    }
    handleSubmitSignUp(event) {
        event.preventDefault();
        if(this.state.password===this.state.pass2) {
            let user = {'firstname':this.state.firstname, 'lastname':this.state.lastname,'username':this.state.username,'password':this.state.password,'country':this.state.country, 'mobile':this.state.mobile};
            UserService.create(user);
            this.home();
        } else {
            alert('Password does not match');
        }
        event.stopPropagation();
    }
    goTo() {
        this.setState({signUp:false});
    }
    signUp() {
        this.setState({signUp:true});
    }
    render() {
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
                    page = this.verifyUser();
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
    verifyUser() {
            if(this.state.signUp===true) {
                return (
                    <div className="App">
                        <header className="App-header">
                                <link
                                rel="stylesheet"
                                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
                                integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
                                crossOrigin="anonymous"
                                />
                        </header>
                        <Container style={{marginTop:"25px", marginBottom:"25px"}}>
                            <Row>
                                <Col className="rounded" style={{backgroundColor:"#007bff"}} md={{ span: 6, offset: 3 }}>
                                    <form className="mr-auto" style={{marginTop:"10px"}} onSubmit={this.handleSubmitSignUp}>
                                        <img className="img" src="./balloons.png" alt="store logo"/>
                                        <h3 className="mr-auto text-center text-light">Sign Up</h3>
    
                                        <div className="form-group">
                                            <label className="text-light">First name</label>
                                            <input type="text" name="firstname" className="form-control" value={this.state.firstname} required placeholder="First name" onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">Last name</label>
                                            <input type="text" name="lastname" className="form-control" value={this.state.lastname} required placeholder="Last name" onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">Phone Number</label>
                                            <input type="tel" name="mobile" className="form-control" value={this.state.mobile} required placeholder="mobile" onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">Country</label>
                                            <input type="text" name="country" className="form-control" value={this.state.country} required placeholder="country" onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">User name</label>
                                            <input type="text" name="username" className="form-control" value={this.state.username} required min="7" placeholder="username" onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">Password</label>
                                            <input type="password" name="password" className="form-control" value={this.state.password} required placeholder="Enter password" pattern='^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$' onChange={this.handleChange}/>
                                        </div>
    
                                        <div className="form-group">
                                            <label className="text-light">Verify Password</label>
                                            <input type="password" name="pass2" className="form-control" value={this.state.pass2} required placeholder="Verify password" onChange={this.handleChange}/>
                                        </div>
    
                                        <button type="submit" className="btn btn-primary btn-block">Sign Up</button>
                                        <Button className="btn btn-primary btn-block" style={{marginBottom:"10px"}} onClick={this.goTo}>Already registered?</Button>
                                    </form>
                                </Col>
                            </Row>
                        </Container>
                    </div>
                );   
            } else if(this.state.flag===true) {
                this.home();
            } else {
                return (
                    <div className="App">
                        <header className="App-header">
                                <link
                                rel="stylesheet"
                                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
                                integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
                                crossOrigin="anonymous"
                                />
                        </header>
                    <div>
                    <Container style={{marginTop:"75px"}}>
                    <Row>
                        <Col className="rounded" style={{backgroundColor:"#007bff"}} md={{ span: 6, offset: 3 }}>
                            <form className="mr-auto" style={{marginTop:"10px"}} onSubmit={this.handleSubmit}>
                                <img className="img" src="./balloons.png" alt="store logo"/>
                                <h3 className="mr-auto text-center text-light">Sign In</h3>
    
                                <div className="form-group">
                                    <label className="text-light">User name</label>
                                    <input type="text" className="form-control" name="uName" value={this.state.uName} placeholder="Enter username" onChange={this.handleChange}/>
                                </div>
    
                                <div className="form-group">
                                    <label className="text-light">Password</label>
                                    <input type="password" id="pass" className="form-control" name="pass" value={this.state.pass} placeholder="Enter password" onChange={this.handleChange}/>
                                </div>
    
                                <button type="submit" className="btn btn-primary btn-block">Submit</button>
                                <Button className="btn btn-primary btn-block" style={{marginBottom:"10px"}} onClick={this.signUp}>SignUp</Button>
                            </form>
                        </Col>
                    </Row>
                    </Container>
                    </div>
                    </div>
            );
        }
    }
}
export default NavBar;