import React, { useEffect, useState}  from 'react'

import TrailTile from './TrailTile'

const TrailsIndex = props => {
  const [trails, setTrails] = useState([])

  const fetchTrails = async () => {
    try {
      const response = await fetch("/api/v1/trails")
      if(!response.ok){
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const trailsData = await response.json()
      setTrails(trailsData.trails)
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
    }
  }

  const trailTiles = trails.map(trail => {
    return(
      <div className="callout primary container">
        <TrailTile
          key={trail.id}
          trail={trail}
        />
      </div>
    )
  })

  useEffect(() => {
    fetchTrails()
  },[])

  return(
    <div>
      <h1>Explore the Nature!</h1>
      {trailTiles}
    </div>
  )
}

export default TrailsIndex