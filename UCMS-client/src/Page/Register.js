import React from 'react'
import { Button, Container, Form, Row ,Alert} from 'react-bootstrap'
import { useFormik } from 'formik'
import validationSchema from '../RegisterValidation/validation'
import {fetchRegister} from '../api'
import { useAuth } from '../Contexts/UserContext'

import { toast } from 'react-toastify'

export default function Register() {
    const{login} = useAuth();

    

    const formik = useFormik({
        initialValues: {
            email: "",
            password: "",
            passwordConfirm: "",
        },
        validationSchema,
        onSubmit: async (values, bag) => {
            try {
                const registerResponse =await fetchRegister(values);
                // console.log(registerResponse)
                
                toast.success("Kullanıcıya Admin Yetkisi Verildi")
                login(registerResponse);
                
                
              
                
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
                        {<h2 style={{ color: "red", textAlign:"center" } }>Register</h2>
                        }
                        {<hr />}
                        {
                            formik.errors.general && (<Alert  variant="danger">
                               Bu Eposta Kullanılıyor.
                              </Alert>)
                            
                        }
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label style={{marginLeft:"9rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Email</b></p></Form.Label>
                            <Form.Control name='email' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.email} placeholder="Email" isInvalid={formik.touched.email && formik.errors.email} />

                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label style={{marginLeft:"8.5rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Password</b></p></Form.Label>
                            <Form.Control name='password' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.password}  placeholder="Password" type='password' isInvalid={formik.touched.password && formik.errors.password} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label style={{marginLeft:"6rem"}} ><p style={{textAlign:"center",color:"yellow"}}><b >Password Confirm</b></p></Form.Label>
                            <Form.Control name='passwordConfirm' onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.passwordConfirm}  placeholder="Password Confirm" type='password' isInvalid={formik.touched.passwordConfirm && formik.errors.passwordConfirm} />
                        </Form.Group>
                        
                        
                        <Button  style={{marginLeft: "7rem", marginTop: "1rem"}} variant="danger" type="submit">
                           <b>Register</b> 
                           
                        </Button>

                    </Form>
                </Row>
            </Container>



        </div>
    )
}
