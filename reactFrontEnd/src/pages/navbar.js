import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Navbar, Nav, Form, FormControl, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';

class NavBar extends React.Component {

    render() {
        return  ( <div>
            <Navbar fixed="top" bg="dark" expand="lg">
            <Navbar.Brand className="text-light" as={Link} to="/">Example Store</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link className="text-light" as={Link} to="/home">Home</Nav.Link>
                    <Nav.Link className="text-light" as={Link} to="/news">News</Nav.Link>
                    <Nav.Link className="text-light" as={Link} to="/account">Account</Nav.Link>
                    <Nav.Link className="text-light" as={Link} to="/cart">Cart</Nav.Link>
                </Nav>
                <Form inline>
                <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                <Button variant="outline-success">Search</Button>
                </Form>
            </Navbar.Collapse>
            </Navbar>
            </div>
        );
    }
}

export default NavBar;