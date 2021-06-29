import React from 'react';

const ImageTile = props => {
  return (
    <div className="image-smol thumbnail">
      <img src={"/images/" + props.imageName} alt="trail image"></img>
    </div>
  );
};

export default ImageTile;