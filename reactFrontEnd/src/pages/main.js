import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Switch} from 'react-router-dom';
import NavBar from './navbar.js'
import Home from './home.js';
import News from './news.js';
import Account from './account.js';
import Cart from './cart.js';
import Item from './item.js';

class Main extends React.Component {
    render() {
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
                
                <BrowserRouter>
                    <NavBar/>
                    <Switch>
                        <Route path="/" exact component={Home}/>
                        <Route path="/home" component={Home}/>
                        <Route path="/news" component={News} />
                        <Route path="/account" component={Account} />
                        <Route path="/cart" component={Cart} /> 
                        <Route path="/item" component={Item} />
                    </Switch> 
                </BrowserRouter>
            </div>
        );
    }
}

export default Main;