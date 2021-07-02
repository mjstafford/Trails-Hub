import React, {useState} from 'react'
import { Redirect } from 'react-router-dom'

import ErrorList from './ErrorList'

const ReviewForm = props => {
  const trailId = props.match.params.id;
  const {name, imgUrl, zipCode} = props.location.state.trail
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)
  const [formData, setFormData] = useState({
    trailId: trailId,
    rating: "",
    comment: "",
    name: "",
    imgUrl: "",
  })

  const submitNewReview = async () => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}/reviews`, {
        method: 'POST',
        headers: new Headers({
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify(formData)
      });
      if (!res.ok) {
        if(res.status === 422) {
          const body = await res.json();
          return setErrors(body.errors);
        } else {
          const error = new Error(`${res.status} (${res.statusText})`);
          throw(error);
        }
      }
      setShouldRedirect(true);
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  };

  const changeHandler = event => {
    setFormData({
      ...formData,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };

  const submitFormHandler = event => {
    event.preventDefault();
    setErrors({});
    submitNewReview();
  };

  if (shouldRedirect) {
    return <Redirect push to={`/trails/${trailId}`} />;
  }

  return (
    <>
      <h1>Review {name}</h1>
      <form onSubmit={submitFormHandler} className="form">
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">User Name: </label>
          <input
            name="name"
            id="name"
            type="text"
            value={formData.name}
            onChange={changeHandler}
          />
        </div>
        <div>
          <label htmlFor="comment">Comment: </label>
          <textarea
            rows="5" cols="33"
            name="comment"
            id="comment"
            type="textarea"
            value={formData.comment}
            onChange={changeHandler}
          />
        </div>
        <div>
          <label htmlFor="imgUrl">Image URL: </label>
          <input
            name="imgUrl"
            id="imgUrl"
            type="text"
            value={formData.imgUrl}
            onChange={changeHandler}
          />
        </div>
        <div>
          <label htmlFor="rating">Rating: </label>
          <div className="rating">
            <input type="radio" id="5" name="rating" value="5" onChange={changeHandler} />
            <label htmlFor="5" className="star-input star-label"></label>
            <input type="radio" id="4" name="rating" value="4" onChange={changeHandler} />
            <label htmlFor="4" className="star-input star-label"></label>
            <input type="radio" id="3" name="rating" value="3" onChange={changeHandler} />
            <label htmlFor="3" className="star-input star-label"></label>
            <input type="radio" id="2" name="rating" value="2" onChange={changeHandler} />
            <label htmlFor="2" className="star-input star-label"></label>
            <input type="radio" id="1" name="rating" value="1" onChange={changeHandler} />
            <label htmlFor="1" className="star-input star-label"></label>
          </div>
        </div>
        <div>
          <input className="button" type="submit"/>
        </div>
      </form>
    </>
  );
}

export default ReviewForm