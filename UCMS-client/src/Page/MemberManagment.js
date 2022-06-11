import { useFormik } from 'formik';
import React from 'react'
import {  Container, Row,  Form, Button } from 'react-bootstrap'

import { memberAdd } from '../api';
import validationSchema from './PostValidations/MemberValidations';
import { toast } from 'react-toastify'

export default function MemberManagment() {

    const formik = useFormik({
        initialValues: {
            memberName: "",
            gender: "",
            email: "",
            department: "",
            position: "",
        },
        validationSchema,
        onSubmit: async (values, bag) => {
            try {
                const registerResponse =await memberAdd(values);
                
                toast.success("Üye Eklendi")

                
    
               
                
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
                    } method='get' action="/" style={{ margin: "5rem", border: "1rem dotted pink", borderRadius: "2rem", paddingLeft: "2rem", paddingRight: "2rem", paddingTop: "2rem", paddingBottom: "2rem" }}>
                        {<h2 style={{ color: "red", textAlign:"center" } }>ADD MEMBER</h2>
                        }
                        {<hr />}
                       <Form.Group className="mb-3" controlId="formBasicPassword">
                       <Form.Label style={{marginLeft:"9rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Name</b></p></Form.Label>
                            <Form.Control name='memberName' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.memberName}  placeholder="Name"  isInvalid={formik.touched.memberName && formik.errors.memberName} />
                        </Form.Group>
                        
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"9rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Email</b></p></Form.Label>
                            <Form.Control name='email' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.email} placeholder="Email" isInvalid={formik.touched.email && formik.errors.email} />
                        </Form.Group>

                        
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Gender</b></p></Form.Label>
                            <Form.Control name='gender' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.gender}  placeholder="Gender"  isInvalid={formik.touched.gender && formik.errors.gender} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label style={{marginLeft:"8rem"}} ><p style={{textAlign:"center", color:"yellow"}}><b >Department</b></p></Form.Label>
                            <Form.Control name='department' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.department}  placeholder="Department"  isInvalid={formik.touched.department && formik.errors.department} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center", color:"yellow"}}><b >Position</b></p></Form.Label>
                            <Form.Control name='position' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.position}  placeholder="Position"  isInvalid={formik.touched.position && formik.errors.position} />
                        </Form.Group>
                        
                        <Button style={{marginLeft: "7rem", marginTop: "1rem"}} variant="danger" type="submit">
                           <b>Add Member</b> 
                        </Button>

                    </Form>
                </Row>
            </Container>



        </div >
    )
}
