import React from 'react'
import { Navbar, Container, Nav, Button, ButtonGroup } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { useAuth } from '../Contexts/UserContext'

export default function Navi() {
  const { loggedIn } = useAuth();
  return (
    <div >

      <Navbar style={{height:"5rem"}} bg="dark" variant="dark">
        <Container>

          <Nav className="me-auto">
            <Link bg="success" to="/">
              <ButtonGroup aria-label="Basic example">
                <Button style={{marginRight:"1rem"}} variant="danger">Home</Button>

              </ButtonGroup>
            </Link>
            <Link to="/ClubManagment">
              <ButtonGroup aria-label="Basic example">
              <Button style={{marginRight:"1rem"}} variant="secondary">Club Managment</Button>

            </ButtonGroup></Link>
            <Link to="/MemberManagment">
              <ButtonGroup aria-label="Basic example">
              <Button style={{marginRight:"1rem"}} variant="info">Member Managment</Button>

            </ButtonGroup></Link>
            <Link to="/EventManagment">
              <ButtonGroup aria-label="Basic example">
              <Button style={{marginRight:"1rem"}} variant="warning">Event Managment</Button>

            </ButtonGroup></Link>

          </Nav>

          {
            !loggedIn && (<>

              <Link to={`/Register`}>
                <Button style={{ marginLeft: "1rem" }} variant="success">Register</Button>
              </Link>

            </>)
          }

          {
            loggedIn && (<><Link to={`/Profile`}>
              <Button style={{ marginLeft: "1rem" }} variant="danger">Profile</Button>
            </Link></>)
          }

        </Container>
      </Navbar>


    </div>
  )
}
