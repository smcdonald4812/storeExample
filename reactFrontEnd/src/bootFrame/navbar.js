import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Navbar, Nav, NavDropdown, Form, FormControl, Button} from 'react-bootstrap';

class NavBar extends React.Component {
    render() {
        return <div>
                    <Navbar fixed="top" bg="dark" expand="lg">
                    <Navbar.Brand href="#home">Example Store</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#news">News</Nav.Link>
                        <Nav.Link href="#account">Account</Nav.Link>
                        <Nav.Link href="#cart">Cart</Nav.Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Deals</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Departments</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Random</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Account</NavDropdown.Item>
                        </NavDropdown>
                        </Nav>
                        <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                    </Navbar>
        </div>;
    }
}

export default NavBar;