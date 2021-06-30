import React, { useState } from 'react';

import DifficultyFormField from './DifficultyFormField';

const FilterForm = props => {
  const [searchFormData, setSearchFormData] = useState({
    difficulty: '',
    zipCode: ''
  });

  const changeHandler = event => {
    setSearchFormData({
      ...searchFormData,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };

  const submitHandler = event => {
    event.preventDefault();
    props.filterTrails(searchFormData);
  }

  return (
    <form onSubmit={submitHandler} >
      <DifficultyFormField changeHandler={changeHandler} difficulty={searchFormData.difficulty} />
    </form>
  );
};

export default FilterForm;