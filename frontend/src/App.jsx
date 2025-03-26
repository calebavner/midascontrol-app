import Main from "./componentes/Main/Main"
import Header from "./componentes/Header/Header"
import Sidedar from "./componentes/Sidebar/Sidedar"
import './App.css'

const App = () => {
  return (
    <div className="app-container">
      <Header />
      <Sidedar />
      <Main />
    </div>
  )
}

export default App
