import React from 'react'

const TrailTile = props =>{
  const {name, imgUrl, distance, difficulty, zipCode} = props.trail

  return(
    <div>
      <div>
        <img src={imgUrl}></img>
      </div>
      <div>
        <h3>{name}</h3>
        <h4>Difficulty: {difficulty}</h4>
        <h4>Distance: {distance}</h4>
        <h4>Location: {zipCode}</h4>
      </div>
    </div>
  )
}

export default TrailTile