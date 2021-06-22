import React from 'react';
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <div className="top-bar">
      <div className="top-bar-left">
        <ul className="menu">
          <li><Link to="/trails">Trails Hub</Link></li>
          <li><Link to="/trails/new">Add A New Hike</Link></li>
        </ul>
      </div>
    </div>
  );
};

export default NavBar;