import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import itemComponent from '../otherComponents/itemComponent';

class Home extends React.Component {

    //going to use pagination to load in 12 item chunks
    loadChoices() {
        const lists = itemComponent.itemList(); 
                var rows = [], columns = [];
                for (let i = 0; i < lists.length; i++) {
                    columns.push(
                        <td key={i.id}>
                                <Card style={{ width: '18rem' }}>
                                    <Card.Img variant="top" src={i.imgURL} />
                                    <Card.Body>
                                        <Card.Title>{i.title}</Card.Title>
                                    <Card.Text>{i.description}</Card.Text>
                                    <Button variant="primary" as={Link} to="/item" key={i.id}>Shop</Button>
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