import React, { useState, useEffect } from 'react';
import { Redirect } from 'react-router-dom';

import ErrorList from './ErrorList';
import DifficultyFormField from './DifficultyFormField';

const TrailEdit = (props) => {
  const trailId = props.match.params.id;
  const [errors, setErrors] = useState({});
  const [shouldRedirect, setShouldRedirect] = useState(false);
  const [formData, setFormData] = useState({
     id: trailId,
     name: "",
     description: "",
     distance: "",
     elevationGain: "",
     difficulty: "",
     zipCode: "",
     imgUrl: ""
  });

  useEffect(() => {
    if(props.location.state) {
      setFormData(props.location.state.trail)
    } else {
      getTrail();
    }
  }, [])

  const getTrail = async () => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}`)
      if (!res.ok) {
        const error = new Error(`${res.status} (${res.statusText})`);
        throw(error);
      }
      const trailData = await res.json();
      setFormData(trailData.trail);
    } catch (e) {
      console.error("Error in fetch: ", e.message);
    }
  }

  const updateTrail = async () => {
    try {
      const res = await fetch(`/api/v1/trails/${trailId}/edit`, {
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
    updateTrail();
  };

  if (shouldRedirect) {
    return <Redirect push to={`/trails/${trailId}`} />;
  }

  return (
    <>
      <h1>Update Trail</h1>
      <form onSubmit={submitFormHandler}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">Name: </label>
          <input
            name="name"
            id="name"
            type="text"
            value={formData.name}
            onChange={changeHandler}
          />
        </div>
        <div>
          <label htmlFor="description">Description: </label>
          <textarea
            rows="5" cols="33"
            name="description"
            id="description"
            type="textarea"
            value={formData.description}
            onChange={changeHandler}
          />
        </div>
        <div>
          <label htmlFor="distance">Distance: </label>
          <input
            name="distance"
            id="distance"
            type="number"
            step=".1"
            value={formData.distance}
            onChange={changeHandler}
          />
          <span> miles</span>
        </div>
        <div>
          <label htmlFor="elevationGain">Elevation Gain: </label>
          <input
            name="elevationGain"
            id="elevationGain"
            type="number"
            step=".1"
            value={formData.elevationGain}
            onChange={changeHandler}
          />
        </div>
        <DifficultyFormField
          changeHandler={changeHandler}
          difficulty={formData.difficulty}
        />
        <div>
          <label htmlFor="zipCode">Location (zip code): </label>
          <input
            name="zipCode"
            id="zipCode"
            type="text"
            value={formData.zipCode}
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
        <input type="submit" className="button" />
      </form>
    </>
  );
};

export default TrailEdit;