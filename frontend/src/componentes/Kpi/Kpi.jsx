import React, { useEffect, useState } from 'react'
import './Kpi.css'

const Kpi = ({kpi}) => {

  const[dados, setDados] = useState([]);
  const[erro, setErro] = useState(null);

  useEffect(() => {
    const buscarDados = async () => {
      try {
        const resposta = await fetch(`http://localhost:8080/registros/total/${kpi}`);
        if(!resposta.ok) {
          throw new Error("Não foi possivel recuperar os dados")
        }
        const dadosJson = await resposta.json();
        setDados(dadosJson);
      } catch(error) {
          setErro(error.message);
      }
    };
    buscarDados();
  }, []);

  

  return (
    <div>
      <h2 className='kpi-value'>{dados.total}</h2>
    </div>
  )
}

export default Kpi
