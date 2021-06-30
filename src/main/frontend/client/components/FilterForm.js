import React, { useState } from 'react';

import DifficultyFormField from './DifficultyFormField';

const FilterForm = props => {
  const [filterFormData, setFilterFormData] = useState({
    difficulty: '',
    zipCode: ''
  });

  const changeHandler = event => {
    setFilterFormData({
      ...filterFormData,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };

  const submitHandler = event => {
    event.preventDefault();
    props.filterTrails(filterFormData);
  }

  return (
    <form onSubmit={submitHandler} >
      <DifficultyFormField changeHandler={changeHandler} difficulty={filterFormData.difficulty} />
    </form>
  );
};

export default FilterForm;