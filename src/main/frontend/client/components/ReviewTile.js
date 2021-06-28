import React, { useState } from "react"

import ReviewImageTile from "./ReviewImageTile"
import ReviewEditForm from "./ReviewEditForm"

const ReviewTile = (props) => {
  const { name } = props.review.user
  const { comment, rating, createdAt, reviewImages } = props.review

  const [editMode, setEditMode] = useState(false)

  const reviewImageTiles = reviewImages.map((imgUrl, index) => {
    return <ReviewImageTile key={index} imgUrl={imgUrl} />
  })

  const date = new Date(createdAt)
  const dateString = date.toDateString()

  const editHandler = (event) => {
    setEditMode(!editMode)
  }

  console.log(props.review)
  if (editMode) {
    return (
      <ReviewEditForm review={props.review} editHandler={editHandler} trailId={props.trailId} dateString={dateString} />
    )
  } else {
    return (
      <div className="callout">
        <div className="grid-x grid-margin-x">
          <div className="cell small-2">
            <p>{name}</p>
          </div>
          <div className="cell small-8">
            <div>
              <p>{dateString}</p>
            </div>
            <div>
              <p>Rating: {rating}/5</p>
            </div>
          </div>
          <div className="cell small-2">
            <button type="button" className="button" onClick={editHandler}>
              Edit Review
            </button>
          </div>
        </div>
        <div className="grid-x grid-margin-x">
          <div className="cell small-12">
            <p>{comment}</p>
          </div>
        </div>
        <div className="grid-x grid-margin-x">
          <div className="cell small-12">{reviewImageTiles}</div>
        </div>
      </div>
    )
  }
}

export default ReviewTile
