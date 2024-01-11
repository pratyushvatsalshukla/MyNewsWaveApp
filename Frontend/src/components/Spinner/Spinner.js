import React from 'react'
import loading from '../resources/loading.gif'
import './Spinner.css'

function Spinner() {
  return (
    <div className='text-center d-flex justify-content-center spinner'>
        <img src={loading} alt="loading" className='spinner-gif' />
    </div>
  )
}

export default Spinner