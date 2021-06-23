import React, {useState} from 'react'
import ErrorList from './ErrorList'


const ReviewForm = props => {
  const trailId = props.match.params.id;
  const {name, imgUrl, zipCode} = props.location.state.trail
  //use state: errors, shouldRedirect, formData
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)
  const [formData, setFormData] = useState({
    rating: "",
    comment: "",
    name: "",
    imgUrls: [],
  })

  //post fetch
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

  //return (form)
  return (
    <>
      <h1>Review {name}</h1>
      <form onSubmit={submitFormHandler}>
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
          <div>
            <input type="radio" id="1" name="rating" value="1" onChange={changeHandler} />
            <label htmlFor="1">1 star</label>
          </div>
          <div>
            <input type="radio" id="2" name="rating" value="2" onChange={changeHandler} />
            <label htmlFor="2">2 star</label>
          </div>
          <div>
            <input type="radio" id="3" name="rating" value="3" onChange={changeHandler} />
            <label htmlFor="3">3 star</label>
          </div>
          <div>
            <input type="radio" id="4" name="rating" value="4" onChange={changeHandler} />
            <label htmlFor="4">4 star</label>
          </div>
          <div>
            <input type="radio" id="5" name="rating" value="5" onChange={changeHandler} />
            <label htmlFor="5">5 star</label>
          </div>
        </div>
        <div>
          <label htmlFor="imgUrl">Image URL: </label>
          <input
            name="imgUrl"
            id="imgUrl"
            type="text"
            value={formData.imgUrls}
            onChange={changeHandler}
          />
        </div>
        <input type="submit"/>
      </form>
    </>
  );
}

export default ReviewForm