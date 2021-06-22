import React from 'react';
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <div className="top-bar">
      <div className="top-bar-left">
        <ul className="menu">
          <Link to="/trails">Trails Hub</Link>
        </ul>
      </div>
    </div>
  );
};

export default NavBar;