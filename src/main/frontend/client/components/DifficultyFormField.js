import React from 'react'

const DifficultyFormField = props => {

  const difficulties = ["", "easy", "medium", "hard"];

  const difficultyOptions = difficulties.map((level, index) => {
    return(
      <option key={index} value={level}>
        {level}
      </option>
    )
  })

  return (
    <div>
      <label htmlFor="difficulty">Difficulty:</label>
      <select name="difficulty" id="difficulty" onChange={props.changeHandler} value={props.difficulty}>
        {difficultyOptions}
      </select>
    </div>
  )
}

export default DifficultyFormField;