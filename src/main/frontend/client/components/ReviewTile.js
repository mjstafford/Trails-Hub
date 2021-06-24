import React from 'react';

import ReviewImageTile from './ReviewImageTile';

const ReviewTile = props => {
  const { name } = props.review.user;
  const { comment, rating, createdAt, reviewImages } = props.review;

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
    </div>
  );
};

export default ReviewTile;