import React from 'react';
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <div className="top-bar grid-x">
      <div className="cell auto"></div>
        <div className="cell small-12 medium-8">
          <div className="top-bar-left">
            <ul className="menu">
              <Link to="/trails">Trails Hub</Link>
              <Link to="/trails">Another thing</Link>
            </ul>
          </div>
        </div>
      <div className="cell auto"></div>
    </div>
  );
};

export default NavBar;