import React from 'react'
import {  useMutation, useQuery } from 'react-query'
import { Link, useParams } from 'react-router-dom'
import {  Container, Button, Row, Col, Card } from 'react-bootstrap'
import { clubDelete } from '../api';
import { toast } from 'react-toastify'


export default function ClubDetail() {


    const { clubId } = useParams();

    const { isLoading, error, data } = useQuery(['repoData', clubId], () =>
        fetch(`http://localhost:8070/api/clubs/getByClubId?clubId=${clubId}`).then(res =>
            res.json())
    )

    const deleteMutation = useMutation(clubDelete);

    if (isLoading) return 'Loading...'
    if (error) return 'An error has occurred: ' + error.message

    

    return (
        <div>

            <Container>
                <Row className="justify-content-md-center">
                    <Col md="auto"  >
                        <Card style={{ margin: '3rem', width: '25rem', borderRadius:"2rem", backgroundColor:"pink" }}>
                            <Card.Img style={{borderRadius:"40%"}} variant="top" src="https://pbs.twimg.com/media/EBtbAKjXkAI8eQS.jpg:large" alt='ESTU' />
                            <Card.Body>
                                <Card.Title></Card.Title>
                                <Link to={`/${clubId}/memberTable`}>
                                    <Button variant="warning">Members Table</Button>
                                </Link>
                                <Link to={`/${clubId}/eventsTable`}>
                                    <Button style={{ marginLeft: "6rem" }} variant="secondary">Events Table</Button>
                                </Link>
                                <hr style={{color:"rose",height:".2rem"}}/>
                                <Button style={{marginLeft: "2rem",marginTop:"0.10rem"}} type='submit' variant="danger" onClick={() => {
                                    deleteMutation.mutate(clubId, toast.danger("Kulüp Silindi"))} }>Delete</Button>
                                    <Link to={`/UpdateClub`}>
                                    <Button style={{ marginLeft: "9rem",marginTop:"0.10rem" }} variant="info">Update</Button>
                                    </Link>
                                    
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container></div>
    )
}
