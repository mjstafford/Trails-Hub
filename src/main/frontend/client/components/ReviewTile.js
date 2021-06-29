import React, { useState } from 'react';
import {Redirect} from 'react-router-dom'

import ImageTile from './ImageTile';

const ReviewTile = props => {
  const { name } = props.review.user;
  const { id, comment, rating, createdAt, images } = props.review;
  const [shouldRedirect, setShouldRedirect] = useState(false)
  const trailId = props.trailId

  const imageTiles = images.map((image, index) => {
    debugger
    return (
      <ImageTile
        key={index}
        imageName={image.imageName}
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
          {imageTiles}
        </div>
      </div>
      <div>
        <button type="button" className="button" onClick={deleteHandler}>Delete Review</button>
      </div>
    </div>
  );
};

export default ReviewTile;