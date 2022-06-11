import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import {

  useQuery,

  useMutation,

  useQueryClient,

  QueryClient,

  QueryClientProvider,

} from 'react-query'
import 'react-toastify/dist/ReactToastify.css';
import { UserProvider } from './Contexts/UserContext';


const queryClient = new QueryClient()
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <QueryClientProvider client={queryClient}> 
  <BrowserRouter>
  <UserProvider>

  <App/>
  </UserProvider>
     
  </BrowserRouter>
  </QueryClientProvider>

);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
