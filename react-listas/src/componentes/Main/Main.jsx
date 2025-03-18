import React from 'react'
import Card from '../Card/Card'
import './Main.css'
import Tabela from '../Tabela/Tabela'

const Main = () => {
  return (
    <main className='main'>

      <div className='secao-kpis'>
        <Card title="Previsão"/>
        <Card title="Faturado"/>
        <Card title="Margem"/>
        <Card title="Comissão"/>
      </div>

      <div className="secao-tabelas">
        <Card title="Previsão de Faturamento">
          <Tabela />
        </Card>
        <Card title="Faturado"/>
      </div>
      
    </main>
  )
}

export default Main
