import React, { useEffect, useState } from 'react'

const Kpi = () => {

  const[dados, setDados] = useState([]);
  const[erro, setErro] = useState(null);

  useEffect(() => {
    const buscarDados = async () => {
      try {
        const resposta = await fetch("http://localhost:8080/registros/total");
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

  if (erro) {
    return <p>Erro: {erro}</p>;
  }

  return (
    <div>
      <h2>R$ {dados.totalExpectado}</h2>
    </div>
  )
}

export default Kpi
