import React from 'react'
import { useQuery } from 'react-query'
import { useParams } from 'react-router-dom'
import { Table, Container, Row, Col, Form, Button } from 'react-bootstrap'
import { clubMember } from '../api';
import validationSchema from './PostValidations/ClubMemberValidation';
import { useFormik } from 'formik';
import { toast } from 'react-toastify'

export default function Members() {

  let numberOfMembers = 1;
  const { clubId } = useParams();

  const { isLoading, error, data } = useQuery(['repoData', clubId], () =>
    fetch(`http://localhost:8070/api/clubs/getByClubId?clubId=${clubId}`).then(res =>
      res.json())
  )

  const formik = useFormik({
    initialValues: {
        clubId: "",
        eventId: "",
    },
    validationSchema,
    onSubmit: async (values, bag) => {
      console.log("DATAAA",data.data)
        try {
            const registerResponse =await clubMember(values);
            
            toast.success("Kulübe Event Eklendi")
            
  
        } catch (e) {
           
            bag.setErrors({general: e.response.data.message})
            
        }
        

    }

})






  if (isLoading) return 'Loading...'
  if (error) return 'An error has occurred: ' + error.message

  console.log("data", data.data.members)

  return (
    <div>
      <Container style={{ marginTop: "5rem" }}>
        <Row>
          <Col>
            {<h2 style={{ textAlign: "center", color: "red" }}> EVENTS TABLE</h2>}
            <Table striped bordered hover style={{ marginTop: "2rem" }} >
              <thead>
                <tr>
                  <th style={{color: "yellow"}}>#</th>
                  <th style={{color: "yellow"}}>Event Name</th>
                  <th style={{color: "yellow"}}>Date Time</th>
                
                </tr>
              </thead>
              <tbody>
                {
                  data.data.events.map((item) => (
                    <tr key={item.eventId}>
                      <td style={{color: "yellow"}}>{numberOfMembers++}</td>
                      <td style={{color: "yellow"}}>{item.eventName}</td>
                      <td style={{color: "yellow"}}>{item.datetime}</td>
                    
                    </tr>
                  ))
                }


              </tbody>
            </Table>

          </Col>
        </Row>

       


      </Container>

      <Container style={{ marginTop: "1rem" }}>
                <Row className="justify-content-md-center" md={3}>

                    <Form onSubmit={formik.handleSubmit
                    } method='get' action="/" style={{ margin: "5rem", border: "1rem dotted pink", borderRadius: "2rem", paddingLeft: "2rem", paddingRight: "2rem", paddingTop: "2rem", paddingBottom: "2rem" }}>
                        {<h2 style={{ color: "red", textAlign:"center" } }>ADD EVENT IN CLUB</h2>
                        }
                        {<hr />}
                     
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Club Id</b></p></Form.Label>
                            <Form.Control name='clubId' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.clubId} placeholder="clubId" isInvalid={formik.touched.clubId && formik.errors.clubId} />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center", color:"yellow"}}><b >Event Id</b></p></Form.Label>
                            <Form.Control name='memberId' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.eventId}  placeholder="eventId"  isInvalid={formik.touched.eventId && formik.errors.eventId} />
                        </Form.Group>
                       
                        
                        <Button style={{marginLeft: "5rem", marginTop: "1rem"}} variant="danger" type="submit">
                           <b>Add Event In Club</b> 
                        </Button>
                        

                    </Form>
                </Row>
            </Container>



    </div>
  )
}