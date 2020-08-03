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
        return this.state.items;
    }
}

export default itemComponent;