import React, { useState } from 'react';

const ImageUploader = props => {
  const [image, setImage] = useState("");
  const [images, setImages] = useState([])
  const [toUpload, setToToUpload] = useState(false);

  const uploadImage = async (body) => {
    const formData  = new FormData();
    formData.append("file", body);
    try {
      const res = await fetch('/images', {
        method: 'POST',
        body: formData
      });
      if (!res.ok) {
       const error = new Error(`${res.status} (${res.statusText})`);
       throw(error);
      }
      const image = await res.json();
      props.addImage(image);
    } catch (e) {
      console.error("error in fetch ", e)
    }
  };

  const addImage = image => {
    setImages([...images, image]);
  };

  const changeHandler = event => {
    const image = event.currentTarget.files[0];

    const reader = new FileReader();
    reader.addEventListener('load', (event) => {
      const imageData = event.target.result;
      addImage(imageData);
    });
    console.log(reader.readAsDataURL(image));

    setImage(image);
  };

  if (image) {
    uploadImage(image);
    setImage("");
  }

  const imgComponents = images.map((image, index) => {
    return (
      <img src={image} />
    );
  });

  return (
    <>
      {imgComponents}
      <input type="file" name="file"  value={image} onChange={changeHandler}/>
    </>
  );
};

export default ImageUploader;