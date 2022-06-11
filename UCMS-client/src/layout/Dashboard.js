import React from 'react'
import { Route, Routes } from 'react-router-dom'
import ClubManagment from '../Page/ClubManagment';
import ClubDetail from '../Page/ClubDetail'
import Clubs from '../Page/Clubs'
import Events from '../Page/Events';
import Register from '../Page/Register';
import Members from '../Page/Members';
import UpdateClub from '../Page/UpdateClub';
import { Container, Image } from 'react-bootstrap';
import Profile from '../Page/Profile';
import EventManagment from '../Page/EventManagment';
import MemberManagment from '../Page/MemberManagment';
import { ToastContainer } from 'react-toastify';


export default function Dashboard() {
  return (
    <div >
      <ToastContainer position='bottom-right'/>
      <Routes>
        <Route exact path="/" element={<Clubs/>}></Route>
        <Route exact path="/:clubId" element={<ClubDetail/>}></Route>
        <Route exact path="/:clubId/memberTable" element={<Members/>}></Route>
        <Route exact path="/:clubId/eventsTable" element={<Events/>}></Route>
        <Route exact path="/Register" element={<Register/>}></Route>
        
        <Route exact path="/ClubManagment" element={<ClubManagment/>}></Route>
        <Route exact path="/MemberManagment" element={<MemberManagment/>}></Route>
        <Route exact path="/EventManagment" element={<EventManagment/>}></Route>
        <Route exact path="/UpdateClub" element={<UpdateClub/>}></Route>
        <Route exact path="/Profile" element={<Profile/>}></Route>
        
      </Routes>
      


    </div>
  )
}
