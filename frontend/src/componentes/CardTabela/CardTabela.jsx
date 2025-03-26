import React from 'react'
import './CardTabela.css'
import Modal from '../Modal/Modal'

const CardTabela = ({ title, children }) => {
  return (
    <div className='card-tabela'>
        <h2>{title}</h2>
      {children}
    </div>
  )
}

export default CardTabela
