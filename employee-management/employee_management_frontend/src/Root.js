import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import App from './App';
import UsersList from './UsersList';

function Root() {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={App} />
        <Route path="/users" component={UsersList} />
      </Switch>
    </Router>
  );
}

export default Root;