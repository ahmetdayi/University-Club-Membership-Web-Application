import React from 'react'

import { useFormik } from 'formik';
import {  Container, Row,  Form, Button } from 'react-bootstrap'

import { eventAdd } from '../api';
import validationSchema from './PostValidations/EventValidations';
import { toast } from 'react-toastify'


export default function AddEvent() {
    const formik = useFormik({
        initialValues: {
            eventName: "",
            datetime:"",
            clubId:"",
        },
        validationSchema,
        onSubmit: async (values, bag) => {
            try {
                const registerResponse = await eventAdd(values);
                toast.success("Event Eklendi")





            } catch (e) {
                console.log("data data data")
                console.log(e)
                bag.setErrors({ general: e.response.data.message })

            }
        }

    })


    return (
        <div>

            <Container style={{ marginTop: "1rem" }}>
                <Row className="justify-content-md-center" md={3}>

                    <Form onSubmit={formik.handleSubmit
                    } method='get' action="/" style={{ margin: "5rem", border: "1rem dotted pink", borderRadius: "2rem", paddingLeft: "2rem", paddingRight: "2rem", paddingTop: "2rem", paddingBottom: "2rem" }}>
                        {<h2 style={{ color: "red", textAlign:"center" } }>ADD EVENT</h2>
                        }
                        {<hr />}

                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"8rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Event Name</b></p></Form.Label>
                            <Form.Control name='eventName' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.eventName} placeholder="eventName" isInvalid={formik.touched.eventName && formik.errors.eventName} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Date Time</b></p></Form.Label>
                            <Form.Control name='datetime' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.datetime} placeholder="datetime " isInvalid={formik.touched.datetime && formik.errors.datetime} />


                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"9rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Club Id</b></p></Form.Label>
                            <Form.Control name='clubId' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.clubId} placeholder="clubId" isInvalid={formik.touched.clubId && formik.errors.clubId} />


                        </Form.Group>

                        
                        <Button style={{marginLeft: "7rem", marginTop: "1rem"}} variant="danger" type="submit">
                           <b>Add Event</b> 
                        </Button>


                    </Form>
                </Row>
            </Container>



        </div >)
}

