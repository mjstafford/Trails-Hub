import React from 'react'

const TrailTile = props =>{
  const {name, imgUrl, distance, difficulty, zipCode} = props.trail

  return(
    <div className="grid-x grid-margin-x ">
      <div className="cell small-12 medium-6 large-6">
        <img src={imgUrl}></img>
      </div>
      <div className="callout secondary cell small-12 medium-6 large-4">
        <h3>{name}</h3>
        <h4>Difficulty: {difficulty}</h4>
        <h4>Distance: {distance}</h4>
        <h4>Location: {zipCode}</h4>
      </div>
    </div>
  )
}

export default TrailTile