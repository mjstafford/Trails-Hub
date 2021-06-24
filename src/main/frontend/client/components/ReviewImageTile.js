import React from 'react';

const ReviewImageTile = props => {
  return (
    <div className="review-image thumbnail">
      <img src={props.imgUrl.imgUrl} alt="reviewer image"></img>
    </div>
  );
};

export default ReviewImageTile;