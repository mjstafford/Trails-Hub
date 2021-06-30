import React from 'react';
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <div className="top-bar">
      <div className="top-bar-left">
        <div className="logo">
          <Link  to="/trails">Trails Hub</Link>
        </div>
      </div>
      <div className="add-button top-bar-right">
        <Link to="/trails/new">Add A Trail!</Link>
      </div>
    </div>
  );
};

export default NavBar;