import React, { useState } from 'react';

const ImageUploader = props => {
  const [image, setImage] = useState("");
  const [toUpload, setToToUpload] = useState(false);

  const uploadImage = async (body) => {
    const formData  = new FormData();
    formData.append("file", body);

    const response = await fetch('/images', {
      method: 'POST',
      body: formData
    });
  }

  const changeHandler = event => {
    setImage(event.currentTarget.files[0]);
  };

  if (image) {
    uploadImage(image);
    setImage("");
  }

  return (
    <>
      File to upload:
      <input type="file" name="file"  value={image} onChange={changeHandler}/>
    </>
  );
};

export default ImageUploader;