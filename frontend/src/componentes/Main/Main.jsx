import React from 'react'
import Card from '../Card/Card'
import './Main.css'
import Tabela from '../Tabela/Tabela'
import Kpi from '../Kpi/Kpi'

const Main = () => {
  return (
    <main className='main'>

      <div className='secao-kpis'>
        <Card title="Previsão">
          <Kpi kpi="expectado"/>
        </Card>
        <Card title="Faturado">
          <Kpi kpi="faturado"/>
        </Card>
        <Card title="Margem">
          <Kpi kpi="margem"/>
        </Card>
        <Card title="Comissão"></Card>
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
