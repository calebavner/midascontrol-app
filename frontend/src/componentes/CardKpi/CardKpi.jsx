import React from 'react'
import './CardKpi.css'
import Icone from '../Icone/Icone'

const CardKpi = ({ title, children, bgColor, icone }) => {
  return (
    <div className='card-kpi'>
      <div>
        <Icone bg={bgColor} icone={<i class={icone}></i>} />
      </div>
      <div className='card-kpi-title'>
        <h2 className='title'>{title}</h2>
        {children}
      </div>
    </div>
  )
}

export default CardKpi
