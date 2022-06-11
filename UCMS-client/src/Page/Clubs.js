import React from 'react'
import { useMutation, useQuery } from 'react-query'
import { Container, Button, Row, Col, Card } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { clubDelete } from '../api'

export default function Clubs() {

    const { isLoading, error, data } = useQuery('repoData', () =>
        fetch("http://localhost:8070/api/clubs/getall").then(res =>
            res.json())
    )

    

    if (isLoading) return 'Loading...'
    if (error) return 'An error has occurred: ' + error.message

   
   console.log(data)
   

    return (
        <div>
            
            <Container>
                <Row md={3}>
                    {
                        data.data.map((item) => (
                            <Col key={item.clubId} >
                                <Card style={{ margin: '3rem', width: '15rem',backgroundColor:"pink" }}>
                                <Link to={`/${item.clubId}`} style={{textDecoration:"none"}}>
                                    <Card.Img style={{backgroundColor:"pink",borderRadius:"40%"}}variant="top" src="https://pbs.twimg.com/media/EBtbAKjXkAI8eQS.jpg:large" alt='ESTU' />
                                    <Card.Body style={{backgroundColor:"pink"}}>
                                        <Card.Title style={{textAlign:"center",  color:"purple" }}><b>ID:({item.clubId})-{item.clubName}</b></Card.Title>
                                        <Button  style={{marginLeft:"4rem"}} variant={"success"}>Details</Button>
                                        
                                    </Card.Body>
                                </Link>
                                
                                 
                                 
                                
                               
                                </Card>
                            </Col>
                        ))
                    }
                    {/* <Button type='submit' variant="danger" onClick={deleteMutation.mutate(clubId)}></Button> */}
                </Row>
            </Container>
        </div>
    )
}
