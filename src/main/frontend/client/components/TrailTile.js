import React from 'react'
import { Link } from 'react-router-dom'

import AverageStarRating from './AverageStarRating'

const TrailTile = props =>{
  const {id, name, imgUrl, distance, difficulty, zipCode, reviews} = props.trail

  return(
    <div className="grid-x grid-margin-x ">
      <div className="cell small-12 medium-6 large-6">
        <Link to={`/trails/${id}`} >
          <img src={imgUrl}></img>
        </Link>
      </div>
      <div className="callout secondary cell small-12 medium-6 large-4">
        <h3><Link to={`/trails/${id}`} >{name}</Link></h3>
        <h4>
          <AverageStarRating reviews={reviews} />
        </h4>
        <h4>Difficulty: {difficulty}</h4>
        <h4>Distance: {distance}</h4>
        <h4>Location: {zipCode}</h4>
      </div>
    </div>
  )
}

export default TrailTile