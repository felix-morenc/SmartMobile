import './App.css';
import BattleScenePage from './pages/BattleScenePage';
import Home from './pages/Home';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import QuestionPage from './pages/QuestionPage';

function App() {

  return (
    <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/battle" element={<BattleScenePage/>}/>
            <Route path="/QuestionPage" element={<QuestionPage/>}/>
          </Routes>
        </BrowserRouter>
        
    </div>
  );
}

export default App;
