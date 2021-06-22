import React, { useEffect } from "react";
import { hot } from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";

import { Switch, Redirect, Route, BrowserRouter } from "react-router-dom";

import NavBar from './NavBar';
import TrailsIndex from './TrailsIndex';

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
    <BrowserRouter>
      <NavBar />
      <Switch>
        <Route exact path="/">
          <Redirect to="/trails" />
        </Route>
        <Route exact path="/trails" component={TrailsIndex} />
      </Switch>
    </BrowserRouter>
  );
};

export default hot(App);
