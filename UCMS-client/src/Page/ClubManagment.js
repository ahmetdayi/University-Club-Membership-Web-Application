import React from 'react'

import { useFormik } from 'formik';
import {  Container, Row,  Form, Button } from 'react-bootstrap'

import { clubAdd } from '../api';
import validationSchema from './PostValidations/ClubValidations';
import { toast } from 'react-toastify'


export default function AddClubs() {
    const formik = useFormik({
        initialValues: {
            clubName: "",
        },
        validationSchema,
        onSubmit: async (values, bag) => {
            try {
                const registerResponse = await clubAdd(values);
                toast.success("Yeni Kulüp Eklendi")





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
                        {<h2 style={{ color: "red", marginLeft:"6rem" }}>ADD CLUB</h2>
                        }
                        {<hr />}

                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label style={{marginLeft:"8rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >CLUB NAME</b></p></Form.Label>
                            <Form.Control name='clubName' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.clubName} placeholder="clubName" isInvalid={formik.touched.clubName && formik.errors.clubName} />

                        </Form.Group>

                        
                        <Button style={{marginLeft: "8rem", marginTop: "1rem"}} variant="danger" type="submit">
                           <b>Add Club</b> 
                        </Button>


                    </Form>
                </Row>
            </Container>



        </div >)
}
