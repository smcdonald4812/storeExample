import React from 'react';
import itemService from '../services/itemService';

class itemComponent extends React.Component {
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

    itemList() {
        let list = [];
        return (
            JSON.stringify(itemService.readItems().then((response) => {
                return response.json();
            }))
        );
    }
}

export default itemComponent;