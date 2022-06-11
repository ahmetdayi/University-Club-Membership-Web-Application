import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dashboard from './layout/Dashboard';

import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import { Container, Image } from 'react-bootstrap';
import Navi from './layout/Navi';


function App() {
  return (
    <div className="bg">
     
      <Navi/>
      <Container >
        <Dashboard />
      </Container>
    </div>
  );
}

export default App;
