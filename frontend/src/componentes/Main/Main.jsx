import React from 'react'
import './Main.css'
import Tabela from '../Tabela/Tabela'
import Kpi from '../Kpi/Kpi'
import CardKpi from '../CardKpi/CardKpi'
import CardTabela from '../CardTabela/CardTabela'
import TabelaFaturados from '../Tabela/TabelaFaturados'

const Main = () => {
  return (
    <main className='main'>

      <div className='secao-kpis'>
        <CardKpi icone="fa-solid fa-chart-simple" bgColor='#3498db' title="Expectativa">          
          <Kpi kpi="expectado"/>
        </CardKpi>

        <CardKpi icone="fa-regular fa-handshake" bgColor='#27ae60' title="Faturado">          
          <Kpi kpi="faturado"/>
        </CardKpi>

        <CardKpi icone="fa-solid fa-percent" bgColor='#f1c40f' title="Margem">          
          <Kpi kpi="margem"/>
        </CardKpi>

        <CardKpi icone="fa-solid fa-sack-dollar" bgColor='#9b59b6' title="Comissão">          
          <Kpi kpi="comissao"/>  
        </CardKpi>
      </div>

      <div className="secao-tabelas">
        <CardTabela title="Previsão de Faturamento">
          <Tabela status="PENDENTE"/>
        </CardTabela>

        <CardTabela title="Faturado" >
          <TabelaFaturados status="FATURADO"/>
        </CardTabela>
      </div>
      
    </main>
  )
}

export default Main
