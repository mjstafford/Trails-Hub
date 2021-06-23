import React from 'react';

const DifficultyFormField = props => {

  const difficulties = ["Easy", "Moderate", "Hard"];

  const difficultyOptions = difficulties.map((level, index) => {
    return (
      <option key={index+1} value={level}>
        {level}
      </option>
    );
  });

  difficultyOptions.unshift(
    <option key={0}>
      Pick an option
    </option>
  );

  return (
    <div>
      <label htmlFor="difficulty">Difficulty:</label>
      <select name="difficulty" id="difficulty" onChange={props.changeHandler} value={props.difficulty}>
        {difficultyOptions}
      </select>
    </div>
  );
};

export default DifficultyFormField;