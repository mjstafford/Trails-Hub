import React from 'react'

const AverageStarRating = props => {
    let starRating = ""
    let missingStars = "★ ".repeat(5)
    let avgRating

    if (props.reviews.length > 0){
      const allRatings = props.reviews.map(review => review.rating)
      const totalStarRating = allRatings.reduce((total, current) => {
        return total + current
      })
      avgRating = Math.round(totalStarRating/allRatings.length)
      starRating = "★ ".repeat(avgRating)
      missingStars = "★ ".repeat(5-avgRating)
    } else {
      missingStars = "Not Rated"
    }

  return (
    <>
      <span className="starRating">{starRating}</span>
      <span className="missingStars">{missingStars}</span>
    </>
  )
}

export default AverageStarRating