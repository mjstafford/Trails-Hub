import React, { useState } from 'react';
import {Redirect} from 'react-router-dom'

import ReviewImageTile from './ReviewImageTile';

const ReviewTile = props => {
  const { name } = props.review.user;
  const {id, comment, rating, createdAt, reviewImages } = props.review;
  const trailId = props.trailId

  const [shouldRedirect, setShouldRedirect] = useState(false)

  const reviewImageTiles = reviewImages.map((imgUrl, index) => {
    return (
      <ReviewImageTile
        key={index}
        imgUrl={imgUrl}
      />
    );
  });

  const date = new Date(createdAt);
  const dateString = date.toDateString();

  const deleteReview = async () => {
    try {
    const res = await fetch(`/api/v1/trails/${trailId}/reviews/${id}/delete`, {
      method: 'DELETE',
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    });
    if (!res.ok) {
      if (!res.ok) {
        const error = new Error(`${res.status} (${res.statusText})`);
        throw(error);
      }
    }
      setShouldRedirect(true);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  if (shouldRedirect) {
    return <Redirect push to={`/trails/${trailId}`} />;
  }

  const onClickDeleteHandler = event => {
    event.preventDefault()
    var result = confirm("Click 'OK' to delete the review")
    if (result) {
        deleteReview()
    }
  }

  return (
    <div className="callout">
      <div className="grid-x grid-margin-x">
        <div className="cell small-2">
          <p>{name}</p>
        </div>
        <div className="cell small-10">
          <div>
            <p>{dateString}</p>
          </div>
          <div>
            <p>Rating: {rating}/5</p>
          </div>
        </div>
      </div>
      <div className="grid-x grid-margin-x">
        <div className="cell small-12">
          <p>{comment}</p>
        </div>
      </div>
      <div className="grid-x grid-margin-x">
        <div className="cell small-12">
          {reviewImageTiles}
        </div>
      </div>
      <div>
        <button type="button" className="button" onClick={onClickDeleteHandler}>Delete Review </button>
      </div>
    </div>
  );
};

export default ReviewTile;