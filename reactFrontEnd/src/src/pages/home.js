import React from 'react';
import {Card, Button} from 'react-bootstrap';
import ItemService from '../services/itemService.js';
import Item from './item.js';

class Home extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            items:[],
            item:[],
            user:this.props.user,
            cart:this.props.cart,
            isClicked:false
        }
        this.go = this.go.bind(this);
    }

    componentDidMount() {
        this.setState({isClicked:false});
        if(this.props.items===undefined) {
            ItemService.getAll().then((response) => {
                this.setState({items: response.data})
            });
        } else {
            this.setState({items:this.props.items});
        }
    }
    go(event) {
        event.preventDefault();
        const value = event.target.value;
        ItemService.get(value).then((response)=>{
            this.setState({item:response.data})
        });
        this.setState({isClicked:true});
        event.stopPropigation();
    }
    //going to use pagination to load in 12 item chunks
    //images will be called from elsewhere once set up
    loadChoices() {
                let rows = [], columns = [];
                let j = 1;
                for (let i = 0; i < this.state.items.length; i++) {
                    columns.push(
                        <td key={this.state.items[i].id}>
                                <form onSubmit={this.go}>
                                    <Card style={{ width: '18rem' }}>
                                        <Card.Img variant="top" src={this.state.items[i].imgURL} alt={this.state.items[i].altText}/>
                                        <Card.Body>
                                            <Card.Title>{this.state.items[i].title}</Card.Title>
                                            <Card.Text>{this.state.items[i].description}</Card.Text>
                                            <Card.Text>{this.state.items[i].price}</Card.Text>
                                        <Button variant="primary" type="submit" name={this.state.items[i].id} key={this.state.items[i].id}>Shop</Button>
                                        </Card.Body>
                                    </Card>
                                </form>
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
        if(this.state.isClicked===true) {
            return (
                <Item user={this.state.user} item={this.state.item} cart={this.state.cart}/>
            );
        } else {
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
}

export default Home;