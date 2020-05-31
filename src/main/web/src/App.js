import React from 'react';
import './App.css';
import {BrowserRouter as Router, Switch, Route, Redirect} from 'react-router-dom'
import Welcome from "./Welcome";


function App() {
    return (
        <div>
            <Router basename={process.env.PUBLIC_URL}>
                <div className="App">
                    <Switch>
                        <Route exact path="/" render={() => (<Redirect to="/welcome"/>)}/>
                        <Route exact path='/welcome' component={Welcome}/>
                    </Switch>
                </div>
            </Router>
        </div>
    );
}

export default App;
