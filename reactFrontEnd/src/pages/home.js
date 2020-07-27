import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';

class Home extends React.Component {

    //going to use pagination to load in 12 item chunks
    loadChoices() {
                var rows = [], columns = [];
                for (let index = 1; index < 12; index++) {
                    columns.push(
                        <td key={index}>
                                <Card style={{ width: '18rem' }}>
                                    <Card.Img variant="top" src="holder.js/100px180" />
                                    <Card.Body>
                                    <Card.Title>Card Title</Card.Title>
                                    <Card.Text>
                                        Some quick example text to build on the card title and make up the bulk of
                                        the card's content.
                                    </Card.Text>
                                    <Button variant="primary" as={Link} to="/item" key={index}>Check it out</Button>
                                    </Card.Body>
                                </Card>
                            </td>
                    )
                    if(index%3==0) {
                        rows.push(
                            <tr>{columns}</tr>
                        )
                        columns=[];
                    }
                }
            return <tbody>{rows}</tbody>;
    }
    
    render() {
        return (
            <div className="mr-auto" style={{ marginTop: "100px"}}>
                <div className="mr-auto">
                    <h1 className="mr-auto">Home page</h1>
                    <table className="table table-borderless">
                        {this.loadChoices()}
                    </table>
                </div>
            </div>
        );
    }
}

export default Home;