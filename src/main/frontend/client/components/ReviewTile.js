import React, { useState } from 'react';
import {Redirect} from 'react-router-dom'

import ReviewImageTile from './ReviewImageTile';

const ReviewTile = props => {
  const { name } = props.review.user;
  const { id, comment, rating, createdAt, reviewImages } = props.review;
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

  const deleteHandler = event => {
    event.preventDefault()
    props.deleteReviewHandler(id);
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
        <button type="button" className="button" onClick={deleteHandler}>Delete Review</button>
      </div>
    </div>
  );
};

export default ReviewTile;