import React, { useState } from "react";
import { toast } from "react-toastify";
// import "react-toastify/dist/ReactToastify.css";
import CustomNavBar from "../NavigationBar/CustomNavBar";
import { Form, FormGroup, Input, Label, Button } from "reactstrap";
import "./Styles.css";
import { signUp } from "../../services/registrationService";
import { Navigate, useNavigate } from "react-router-dom";
import Footer from "../Footer/Footer";

const Signup = () => {

    const navigate = useNavigate();
  const navigateLogin = () => navigate("/login");

  const [data, setData] = useState({
    // saving the data which user is entering into the form.
    name: "",
    emailId: "",
    password: "",
  });

  const handleChange = (event) => {
    setData({ ...data, [event.target.name]: event.target.value }); // Setting the data with setData on 'onChange' of forms.
  };

  // RESET FORM
  const resetData = () => {
    // console.warn("Resetting the Form Data !")
    setData({
      name: "",
      emailId: "",
      password: "",
    });
  };

  // Process Data and Submit Form To Database
  const submitForm = (event) => {
    // console.info("Submitting the Form Data !")
    event.preventDefault();
    // console.log(data);
    // Data Validation
    // Call API
    if(/^[a-zA-Z]+$/.test(data.name)) // Checking if username has only string or not
    {
      signUp(data)
      .then((response) => {
        // When promise is fulfilled !
        // console.info("Registration Successful!")
        toast.success("Registration Successful !!");
        setData({
          name: "",
          emailId: "",
          password: "",
        });
        // console.info("Navigating to Login Page !")
        navigateLogin(); // On Successful Registration, User will be redirected to the Login Page.
      })
      .catch((error) => {
        // console.error("Signup : Promise Returned Error !")
        toast.error(error.response.data); // promise returning error
      });
    }
    else{
      toast.error("Name Should Contain Only Strings. And It Should Not Be Null")
    }

  };

  return (
    sessionStorage.data? ( toast.error("You Are Already Logged In!!"),<Navigate to="/user/dashboard"/> ):
    <div className="signup-main main-container-signup">
      <CustomNavBar />
      <Form className="signup-form" onSubmit={submitForm}>
        <h1 className="registereader">Register Here !</h1>
        <FormGroup floating>
          <Input
            id="nameInput"
            name="name"
            placeholder="Name"
            type="text"
            onChange={(event) => handleChange(event)} // Performing Data Binding and passing event to the handleChange method.
            value={data.name}
          />
          <Label for="nameInput">Name</Label>
        </FormGroup>
        <FormGroup floating>
          <Input
            id="emailId"
            name="emailId"
            placeholder="Email"
            type="email"
            onChange={(event) => handleChange(event)}
            value={data.emailId}
          />
          <Label for="emailId">Email</Label>
        </FormGroup>
        <FormGroup floating>
          <Input
            id="password"
            name="password"
            placeholder="Password"
            type="password"
            onChange={(event) => handleChange(event)}
            value={data.password}
          />
          <Label for="password">Password</Label>
        </FormGroup>
        <Button block color="primary" className="register-button">
          Click Here To Register
        </Button>
        <Button
          block
          color="danger"
          className="reset-button"
          onClick={resetData}
        >
          Click Here To Reset
        </Button>
      </Form>
      <Footer />
    </div>
  );
};

export default Signup;

// REMOVE USE EFFECT IN LINE 13
