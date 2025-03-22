import React from 'react'
import './Icone.css'

const Icone = ({icone, bg}) => {
  
  const estilo = {
    background: bg || '#9b59b6'
  };

  return (
    <div className='icone-container' style={estilo}>
      {icone}  
    </div>
  )
}

export default Icone
