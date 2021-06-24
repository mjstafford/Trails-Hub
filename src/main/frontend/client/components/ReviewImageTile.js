import React from 'react';

const ReviewImageTile = props => {
  return (
    <div className="thumbnail">
      <img src={props.imgUrl.imgUrl} alt="reviewer image"></img>
    </div>
  );
};

export default ReviewImageTile;