import React, { useState, useEffect } from 'react';
import { Link, Redirect } from 'react-router-dom'

const TrailShow = props => {
  const [trail, setTrail] = useState({});
  const [shouldRedirect, setShouldRedirect] = useState(false)
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

    const deleteTrail = async () => {
      console.log("HIT deleteTrail fetch")
      try {
      const res = await fetch(`/api/v1/trails/${trailId}/delete`, {
        method: 'DELETE',
        headers: new Headers({
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify({"trailId": trailId})
      });
      if (!res.ok) {
        //conflict error code
        if(res.status === 409) {
          const body = await res.json();
          return setErrors(body.errors);
        } else {
          const error = new Error(`${res.status} (${res.statusText})`);
          throw(error);
        }
      }
        setShouldRedirect(true);
      } catch (e) {
        console.error("Error in fetch: ", e.message);
      }
    }

  useEffect(() => {
    getTrail();
  }, []);

  if (shouldRedirect) {
    return <Redirect push to={`/trails`} />
  }

  const onClickDeleteHandler = event => {
    event.preventDefault()
    var result = confirm("Click 'OK' to delete the trail")
    if (result) {
        deleteTrail()
    }
  }

  return (
    <div>
      <div>
        <img src={imgUrl} />
      </div>
      <Link to={{ pathname: `/trails/${trailId}/reviews/new`, state: { trail: trail} }} >Add Review</Link>
      <div>
        <h1>{name}</h1>
      </div>
      <div className="grid-x grid-margin-x">
        <div className="cell small-12 medium-4">
          <p>Difficulty: {difficulty}</p>
          <p>Distance: {distance} miles</p>
          <p>Elevation Gain: {elevationGain} ft</p>
          <p>Location: {zipCode}</p>
          <div className="grid-x grid-margin-x">
            <div className="cell small-5">
              <Link
                to={{ pathname: `/trails/${trailId}/edit`, state: { trail: trail } }}>
                <button type="button" className="button">Edit Trail</button>
              </Link>
            </div>
            <div className="cell small-6">
              <button type="button" className="button" onClick={onClickDeleteHandler} >Delete Trail</button>
            </div>
          </div>
        </div>
        <div className="cell small-12 medium-8">
          <h3>Description</h3>
          <p>{description}</p>
        </div>
      </div>
    </div>
  );
};

export default TrailShow;