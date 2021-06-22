import React, { useState, useEffect } from 'react';

const TrailShow = props => {
  const [trail, setTrail] = useState({});
  const trailId = props.match.params.id;

  const {
    name,
    description,
    distance,
    elevationGain,
    difficulty,
    zipCode,
    rating,
    imgUrl
  } = trail;

  const getTrail = async () => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}`);
      if (!res.ok) {
        const error = new Error(`${res.status} (${res.statusText})`);
        throw(error);
      }
      const trailData = await res.json();
      setTrail(trailData.trail);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  useEffect(() => {
    getTrail();
  }, []);

  return (
    <div>
      <div>
        <img src={imgUrl} />
      </div>
      <div>
        <h1>{name}</h1>
      </div>
      <div className="grid-x grid-margin-x">
        <div className="cell small-12 medium-4">
          <p>Difficulty: {difficulty}</p>
          <p>Distance: {distance} miles</p>
          <p>Elevation Gain: {elevationGain} ft</p>
          <p>Location: {`${zipCode}`}</p>
        </div>
        <div className="cell small-12 medium-8">
          <h3>Description</h3>
          <p>{`${description}`}</p>
        </div>
      </div>
    </div>
  );
};

export default TrailShow;