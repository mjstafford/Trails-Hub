import React, { useEffect } from "react";
import { hot } from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";
import "../assets/scss/main.scss"


import { Switch, Redirect, Route, BrowserRouter } from "react-router-dom";

import NavBar from './NavBar';
import TrailShow from './TrailShow';
import TrailsIndex from './TrailsIndex';

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
    <BrowserRouter>
      <NavBar />
      <div className="grid-x grid-margin-x">
        <div className="cell auto"></div>
          <div className="cell small-12 medium-8">
            <Switch>
              <Route exact path="/">
                <Redirect to="/trails" />
              </Route>
              <Route exact path="/trails/:id" component={TrailShow} />
              <Route exact path="/trails" component={TrailsIndex} />
            </Switch>
          </div>
        <div className="cell auto"></div>
      </div>
    </BrowserRouter>
  );
};

export default hot(App);