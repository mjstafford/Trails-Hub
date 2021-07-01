import React from 'react'
import { Link } from 'react-router-dom'

const TrailTile = props =>{
  const {id, name, imgUrl, distance, difficulty, zipCode} = props.trail

  return(
    <div className="grid-x grid-margin-x trail-tile">
      <div className="cell small-12 medium-6 large-6 trail-tile-img">
        <Link to={`/trails/${id}`} >
          <img src={imgUrl}></img>
        </Link>
      </div>
      <div className="callout secondary cell small-12 medium-6 large-4">
        <h3><Link to={`/trails/${id}`} >{name}</Link></h3>
        <h4>Difficulty: {difficulty}</h4>
        <h4>Distance: {distance}</h4>
        <h4>Location: {zipCode}</h4>
      </div>
    </div>
  )
}

export default TrailTile