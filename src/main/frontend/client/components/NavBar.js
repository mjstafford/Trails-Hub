import React, { useState } from 'react';
import { Link } from "react-router-dom";

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
        <div className="top-bar-right cell medium-4">
          <input
            type="text"
            placeholder="search trails"
            value={searchInput}
            onChange={changeHandler}
          />
        </div>
        <Link to={`/trails/search/${searchInput}`}>
          <button type="button" className="button">
            <i className="fas fa-search"></i>
            {/* Search */}
          </button>
        </Link>
      </div>
      <div className="cell auto"></div>
    </div>
  )
};

export default NavBar;