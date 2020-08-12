import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import NavBar from './navbar.js';

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
                <NavBar/>
            </div>
        );
    }
}

export default Main;