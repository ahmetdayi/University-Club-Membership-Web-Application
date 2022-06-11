import React from 'react'
import { Container, Button, Row, Col, Card,Form } from 'react-bootstrap'
import { useQuery } from 'react-query'
import { Link, useParams } from 'react-router-dom'
import { useAuth } from '../Contexts/UserContext'

export default function Profile() {

    const { user } = useAuth();

    console.log(user);


    return (
        <div>

            <Container style={{ marginTop: "1rem" }}>
                <Row className="justify-content-md-center" md={3} >
                    <Card style={{ width: '18rem' }}>
                        <Card.Img  variant="top" src="https://img2.pngindir.com/20180920/efk/kisspng-user-logo-information-service-design-5ba34f88a0c3a6.5907352915374293846585.jpg" style={{ borderRadius: "100% ", border: "1px solid" }} />
                        <Card.Body>
                            <Card.Title >Admin Profile</Card.Title>
                            <>
                            <Form.Label>Admin Yetkisi verildi :</Form.Label> <br/>
                            <Form.Label>Eposta:</Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="ahmet.dayi.ceng@gmail.com"
                                    aria-label="Disabled input example"
                                    disabled
                                    readOnly
                                />
                                <br />
                                <Form.Label>Admin Adı:</Form.Label>
                                <Form.Control style={{textAlign:"center"}}
                                    type="text"
                                    placeholder="Ahmet Dayı"
                                    aria-label="Disabled input example"
                                    readOnly
                                />
                            </>
                            
                        </Card.Body>
                    </Card>
                </Row>
            </Container>

        </div>
    )
}
