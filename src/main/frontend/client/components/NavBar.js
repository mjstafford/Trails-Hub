import React, { useState } from 'react';
import { Link, Re } from "react-router-dom";

const NavBar = () => {
  const [searchInput, setSearchInput] = useState("")

  const changeHandler = (event) => {
    setSearchInput(event.currentTarget.value)
  }

  return (
    <div className="top-bar grid-x">
      <div className="cell auto"></div>
        <div className="grid-x cell small-12 medium-8">
          <div className="top-bar-left cell medium-4">
            <ul className="menu">
              <Link to="/trails">Trails Hub</Link>
              <Link to="/trails/new">Add A New Hike</Link>
            </ul>
          </div>
        </div>
      <div className="cell auto"></div>
    </div>
  )
};

export default NavBar;