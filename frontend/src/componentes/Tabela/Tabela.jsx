import React, { useState, useEffect } from "react";
import './Tabela.css'
import Modal from "../Modal/Modal";

const Tabela = ({ status }) => {
  // Estado para armazenar os dados da API
  const [dados, setDados] = useState([]);
  // Estado para controlar o carregamento
  const [carregando, setCarregando] = useState(true);
  // Estado para armazenar erros, caso ocorram
  const [erro, setErro] = useState(null);

  // Função para buscar os dados da API
  useEffect(() => {
    const buscarDados = async () => {
      try {
        const resposta = await fetch(`http://localhost:8080/registros/status?status=${status}`); // Substitua pela URL da sua API
        if (!resposta.ok) {
          throw new Error("Erro ao carregar os dados");
        }
        const dadosJson = await resposta.json();
        setDados(dadosJson); // Atualiza o estado com os dados da API
      } catch (error) {
        setErro(error.message); // Atualiza o estado de erro
      } finally {
        setCarregando(false); // Finaliza o carregamento
      }
    };

    buscarDados();
  }, []); // O array vazio [] garante que o useEffect só rode uma vez (equivalente ao componentDidMount)

  // Renderização condicional
  if (carregando) {
    return <p>Carregando...</p>;
  }

  if (erro) {
    return <p>Erro: {erro}</p>;
  }

  // Renderiza a tabela de dados
  return (
    <div>
      <table className="tabela">
        <thead>
          <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Valor</th>
            <th>Margem</th>
            <th>Status</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {dados.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.cliente}</td>
              <td>R${item.valor}</td>
              <td>{item.margem}%</td>
              <td><a href="#">{item.status}</a></td>
              <td className="container-btn">
                <button type="button" class="btn btn-success btn-sm">Faturar</button>
                <button type="button" class="btn btn-danger btn-sm">Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="container-modal">
        <Modal />
      </div>
    </div>
  );
};

export default Tabela;