import React from 'react'
import './CardTabela.css'

const CardTabela = ({ title, children }) => {
  return (
    <div className='card-tabela'>
      <h2>{title}</h2>
      {children}
    </div>
  )
}

export default CardTabela
