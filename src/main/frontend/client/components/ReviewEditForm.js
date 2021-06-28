import React, { useState } from 'react'

import ErrorList from './ErrorList'

const ReviewEditForm = props => {

  const [formData, setFormdata] = useState(props.review)
  const [errors, setErrors] = useState({})

  const reviewId = props.review.id
  const trailId = props.trailId
  const dateString = props.dateString
  const editHandler = props.editHandler

  const editReview = async () => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}/reviews/${reviewId}`, {
        method: 'PUT',
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

  const submitHandler = (event) => {
    event.preventDefault()
    setErrors({});
    editReview()
  }

  return (
    <div className="callout">
      <div className="grid-x grid-margin-x">
        <div className="cell small-2">
          <p>{formData.user.name}</p>
        </div>
        <div className="cell small-8">
          <div>
            <p>{dateString}</p>
          </div>
        </div>
        <div className="cell small-2">
          <button type="button" className="button" onClick={editHandler}>
            Cancel
          </button>
        </div>
      </div>
      <form onSubmit={submitHandler}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="comment">Comment: </label>
          <textarea
            rows="5"
            cols="33"
            name="comment"
            id="comment"
            type="textarea"
            value={formData.comment}
            onChange={changeHandler}
          />
        </div>
        <div>
          <div>
            <input
              type="radio"
              id="1"
              name="rating"
              value="1"
              onChange={changeHandler}
            />
            <label htmlFor="1">1 star</label>
          </div>
          <div>
            <input
              type="radio"
              id="2"
              name="rating"
              value="2"
              onChange={changeHandler}
            />
            <label htmlFor="2">2 star</label>
          </div>
          <div>
            <input
              type="radio"
              id="3"
              name="rating"
              value="3"
              onChange={changeHandler}
            />
            <label htmlFor="3">3 star</label>
          </div>
          <div>
            <input
              type="radio"
              id="4"
              name="rating"
              value="4"
              onChange={changeHandler}
            />
            <label htmlFor="4">4 star</label>
          </div>
          <div>
            <input
              type="radio"
              id="5"
              name="rating"
              value="5"
              onChange={changeHandler}
            />
            <label htmlFor="5">5 star</label>
          </div>
        </div>
        <div>
          <label htmlFor="imgUrl">Image URL: </label>
          <input
            name="imgUrl"
            id="imgUrl"
            type="text"
            value={ (formData.reviewImages) ? formData.reviewImages[0].imgUrl : "" }
            onChange={changeHandler}
          />
        </div>
        <input type="submit" />
      </form>
    </div>
  )
}

export default ReviewEditForm