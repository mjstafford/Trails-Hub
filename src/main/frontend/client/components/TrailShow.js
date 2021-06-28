import React, { useState, useEffect } from 'react';
import {Link} from 'react-router-dom';

import ReviewTile from './ReviewTile';

const TrailShow = props => {
  const [trail, setTrail] = useState({});
  const [reviews, setReviews] = useState([]);
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
      setReviews(trailData.trail.reviews);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  const reviewTiles = reviews.map(review => {
    return (
      <ReviewTile
        key={review.id}
        review={review}
        trailId={trailId}
        trail={trail}
      />
    );
  });

  useEffect(() => {
    getTrail();
  }, []);

  return (
    <div>
      <div>
        <img src={imgUrl} />
      </div>
      <Link to={{ pathname: `/trails/${trailId}/reviews/new`, state: { trail: trail} }} >Add Review</Link>
      <div>
        <h1>{name}</h1>
      </div>
      <div className="grid-x grid-margin-x callout primary">
        <div className="cell small-12 medium-4 callout">
          <p><span className="labelKey">Difficulty</span>: {difficulty}</p>
          <p><span className="labelKey">Distance</span>: {distance} miles</p>
          <p><span className="labelKey">Elevation Gain</span>: {elevationGain} ft</p>
          <p><span className="labelKey">Location</span>: {zipCode}</p>
          <Link
            to={{ pathname: `/trails/${trailId}/edit`, state: { trail: trail } }}>
            <button type="button" className="button">Edit Trail</button>
          </Link>
        </div>
        <div className="cell small-12 medium-8">
          <h5>Description</h5>
          <p>{description}</p>
        </div>
      </div>
      <div>
        <h4>User Reviews</h4>
        {reviewTiles}
      </div>
    </div>
  );
};

export default TrailShow;