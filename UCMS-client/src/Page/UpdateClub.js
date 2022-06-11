import { useFormik } from 'formik';
import React from 'react'
import {  Container, Row,  Form, Button } from 'react-bootstrap'

import { clubUpdate } from '../api';
import validationSchema from './PostValidations/ClubValidations';

export default function UpdateClub() {

    const formik = useFormik({
        initialValues: {
           clubName:"",
        },
        validationSchema,
        onSubmit: async (values, bag) => {
            try {
                const registerResponse =await clubUpdate(values);
                // console.log(registerResponse)
                console.log(registerResponse)

                
    
               
                
            } catch (e) {
                console.log("data data data")
                console.log(e)
                bag.setErrors({general: e.response.data.message})
                
            }
        }

    })


    return (
        <div>

<Container style={{ marginTop: "1rem" }}>
                <Row className="justify-content-md-center" md={3}>

                    <Form onSubmit={formik.handleSubmit
                    } method='get' action="/" style={{ margin: "5rem", border: "1rem solid blue", borderRadius: "2rem", paddingLeft: "2rem", paddingRight: "2rem", paddingTop: "2rem", paddingBottom: "2rem" }}>
                        {<h2 style={{ color: "red" }}>Register</h2>
                        }
                        {<hr />}
                       
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control name='email' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.clubName} placeholder="clubName" isInvalid={formik.touched.clubName && formik.errors.clubName} />


                            <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                            </Form.Text>
                        </Form.Group>

                        
                        <Button variant="primary" type="submit">
                            Register
                        </Button>
                        

                    </Form>
                </Row>
            </Container>



        </div >
    )
}
