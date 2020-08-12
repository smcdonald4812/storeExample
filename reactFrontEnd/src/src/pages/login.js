import React from 'react';
import UserService from '../services/userService.js';
import {Button, Container, Row, Col} from 'react-bootstrap';
import NavBar from './navbar.js';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            flag:false,
            signUp:false,
            user:[],
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
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleSubmitSignUp = this.handleSubmitSignUp.bind(this);
        this.goTo = this.goTo.bind(this);
        this.signUp = this.signUp.bind(this);
    }
    handleChange(event) {
        const value = event.target.value;
        const name = event.target.name;
        this.setState({
            [name]: value
        });
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
                this.setState({flag:true});
            }
        }
        event.stopPropagation();
    }
    handleSubmitSignUp(event) {
        event.preventDefault();
        if(this.state.password===this.state.pass2) {
            let user = {'firstname':this.state.firstname, 'lastname':this.state.lastname,'username':this.state.username,'password':this.state.password,'country':this.state.country, 'mobile':this.state.mobile};
            UserService.create(user);
            this.setState({signUp:false});
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
            return (<NavBar user={this.state.user} item={this.props.item} cart={this.props.cart} justLogged={true}/>);
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
export default Login;