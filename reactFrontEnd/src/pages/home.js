import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import itemService from '../services/itemService';

class Home extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            items:[]
        }
    }

    componentDidMount() {
        itemService.readItems().then((response) => {
            this.setState({ items: response.data})
        });
    }

    //going to use pagination to load in 12 item chunks
    //images will be called from elsewhere once set up
    loadChoices() {
                var rows = [], columns = [];
                let j = 1;
                for (let i = 0; i < this.state.items.length; i++) {
                    columns.push(
                        <td key={this.state.items[i].id}>
                                <Card style={{ width: '18rem' }}>
                                    <Card.Img variant="top" src={this.state.items[i].imgURL} alt={this.state.items[i].altText}/>
                                    <Card.Body>
                                        <Card.Title>{this.state.items[i].title}</Card.Title>
                                        <Card.Text>{this.state.items[i].description}</Card.Text>
                                        <Card.Text>{this.state.items[i].price}</Card.Text>
                                    <Button variant="primary" as={Link} to="/item" name={this.state.items[i].id} key={this.state.items[i].id}>Shop</Button>
                                    </Card.Body>
                                </Card>
                            </td>
                    )
                    if(j%3===0) {
                        rows.push(
                            <tr>{columns}</tr>
                        )
                        columns=[];
                    }
                    j++;
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