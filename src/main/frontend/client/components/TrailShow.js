import React, { useState, useEffect } from 'react';
import { Link, Redirect } from 'react-router-dom'

import ReviewTile from './ReviewTile';
import StarRating from './StarRating';

const TrailShow = props => {
  const [trail, setTrail] = useState({});
  const [reviews, setReviews] = useState([]);
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
      setReviews(trailData.trail.reviews);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  const deleteTrail = async () => {
    console.log("HIT deleteTrail fetch")
    try {
      const res = await fetch(`/api/v1/trails/${trailId}`, {
        method: 'DELETE',
        headers: new Headers({
          'Content-Type': 'application/json'
        })
      });
      if (!res.ok) {
        const error = new Error(`${res.status} (${res.statusText})`);
        throw(error);
      }

      setShouldRedirect(true);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  const deleteReview = async (reviewId) => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}/reviews/${reviewId}`, {
        method: 'DELETE',
        headers: new Headers({
          'Content-Type': 'application/json'
        })
      });
      if (!res.ok) {
        const error = new Error(`${res.status} (${res.statusText})`);
        throw(error);
      }
      setReviews(
        reviews.filter(review => review.id != reviewId)
      )
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  useEffect(() => {
    getTrail();
  }, []);

  const deleteTrailHandler = event => {
    event.preventDefault()
    var result = confirm("Click 'OK' to delete the trail")
    if (result) {
        deleteTrail()
    }
  }

  const deleteReviewHandler = reviewId => {
    var result = confirm("Click 'OK' to delete the review")
    if (result) {
        deleteReview(reviewId)
    }
  }

  const reviewTiles = reviews.map(review => {
    return (
      <ReviewTile
        key={review.id}
        review={review}
        trailId={trailId}
        trail={trail}
        getTrail={getTrail}
        deleteReviewHandler={deleteReviewHandler}
      />
    );
  });

  if (shouldRedirect) {
    return <Redirect push to={`/trails`} />
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
      <div className="grid-x grid-margin-x callout primary">
        <div className="cell small-12 medium-12 large-4 callout">
          <div>
            <p>
              <span className="labelKey">Rating:</span>
              <StarRating reviews={reviews} />
            </p>
          </div>
          <p><span className="labelKey">Difficulty</span>: {difficulty}</p>
          <p><span className="labelKey">Distance</span>: {distance} miles</p>
          <p><span className="labelKey">Elevation Gain</span>: {elevationGain} ft</p>
          <p><span className="labelKey">Location</span>: {zipCode}</p>
          <div className="grid-x grid-margin-x">
            <div className="cell small-5">
              <Link
                to={{ pathname: `/trails/${trailId}/edit`, state: { trail: trail } }}>
                <button type="button" className="button">Edit Trail</button>
              </Link>
            </div>
            <div className="cell small-6">
              <button type="button" className="button" onClick={deleteTrailHandler}>Delete Trail </button>
            </div>
          </div>
        </div>
        <div className="cell small-12 medium-12 large-8">
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