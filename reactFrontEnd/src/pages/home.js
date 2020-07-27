import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';

class Home extends React.Component {

    loadChoices() {
                var rows = [];
                for (let index = 0; index < 1; index++) {
                    rows.push(
                        <div key="index">
                            <Card style={{ width: '18rem' }}>
                                <Card.Img variant="top" src="holder.js/100px180" />
                                <Card.Body>
                                <Card.Title>Card Title</Card.Title>
                                <Card.Text>
                                    Some quick example text to build on the card title and make up the bulk of
                                    the card's content.
                                </Card.Text>
                                <Button variant="primary" as={Link} to="/item">Check it out</Button>
                                </Card.Body>
                            </Card>
                        </div>
                    )
                }
            return <tbody>{rows}</tbody>;
    }
    
    render() {
        return (
            <div className="mr-auto" style={{ marginTop: "100px"}}>
                <div className="mr-auto">
                    <h1>Home page</h1>
                    <table className="table table-borderless">
                        {this.loadChoices()}
                    </table>
                </div>
            </div>
        );
    }
}

export default Home;