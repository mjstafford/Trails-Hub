import React, { useState } from "react"
import { Redirect } from "react-router-dom"

import ReviewImageTile from "./ReviewImageTile"
import ReviewEditForm from "./ReviewEditForm"
import AverageStarRating from "./AverageStarRating"

const ReviewTile = (props) => {
  const { name } = props.review.user
  const { id, comment, rating, createdAt, reviewImages } = props.review
  const trailId = props.trailId
  const [editMode, setEditMode] = useState(false)

  const reviewImageTiles = reviewImages.map((imgUrl, index) => {
    return <ReviewImageTile key={index} imgUrl={imgUrl} />
  })

  const date = new Date(createdAt)
  const dateString = date.toDateString()

  const editHandler = () => {
    setEditMode(!editMode)
  }

  const deleteHandler = (event) => {
    event.preventDefault()
    props.deleteReviewHandler(id)
  }

  if (editMode) {
    return (
      <ReviewEditForm
        review={props.review}
        editHandler={editHandler}
        trailId={props.trailId}
        trail={props.trail}
        dateString={dateString}
        getTrail={props.getTrail}
      />
    )
  } else {
    return (
      <div className="callout">
        <div className="grid-x grid-margin-x">
            <div className="review-data">
              <span>
                <img className="user-image" src="/hikericon.png" alt="user icon"/>
              </span>
              <span className="username-rating">
                <p className="user-name">{name}</p>
                <AverageStarRating reviews={[props.review]}/>
              </span>
              <span className="date">
                {dateString}
              </span>
            </div>
        </div>
        <div className="comment-body grid-x grid-margin-x">
          <div className="cell small-12">
            <p>{comment}</p>
          </div>
        </div>
        <div className="grid-x grid-margin-x">
          <div className="review-images cell small-12">
            {reviewImageTiles}</div>
        </div>
        <div className="review-config">
          <a className="delete-review" onClick={deleteHandler}>
            delete
          </a>
          <a className="edit-review"onClick={editHandler}>
            edit
          </a>
        </div>
      </div>
    )
  }
}

export default ReviewTile