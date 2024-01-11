import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import CustomNavBar from "../NavigationBar/CustomNavBar";
import { Form, FormGroup, Input, Label, Button } from "reactstrap";
import "../Login/Login.css";
import { logIn } from "../../services/loginService";
import { doLogin } from "../../authentication/CheckAuthentication";
import { useNavigate } from "react-router-dom";
import Footer from "../Footer/Footer";
import { Navigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const navigateDashboard = () => navigate("/user/dashboard");

  const [data, setData] = useState({
    // Setting EmailId and Password Entered By The User in Login Form
    emailId: "",
    password: "",
  });

  useEffect(() => {
    // Re rendering the page once data is gettting changed.
    // console.warn("Login : Setting Values to the Data in backend !");
  }, [data]);

  const handleChange = (event) => {
    //setting the data to the respoctive fields.
    // console.info("Login : Setting User Data !");
    setData({ ...data, [event.target.name]: event.target.value });
  };

  const resetData = () => {
    // Resetting the values entered by the user.
    // console.warn("Login : Resetting User Data !");
    setData({
      emailId: "",
      password: "",
    });
  };

  const submitForm = (event) => {
    event.preventDefault(); // Preventing the default nature of Form Submit event for further validations.
    // Data Validation
    // console.info("Login :  Validationg The Data !");

    if (data.emailId.trim() === "") {
      // console.error("Login : Please Enter Email ID");
      toast.error("Please Enter Email ID");
      return;
    } else if (data.password.trim() === "") {
      // console.error("Login : Please Enter Password");

      toast.error("Please Enter Your Password");
      return;
    }
    // Call API
    logIn(data)
      .then((response) => {
        doLogin(response, () => {
          // Saving Login Details To The Local Storage.
          // console.info("Login :  Data Successfully Saved To Local Storage !!");
          // console.log("Login Data Successfully Saved To Local Storage !!");
          // Here we have to redirect to user dashboard page.
          // console.warn("Login :  Redirecting To Dashboard Page !!");
          navigateDashboard(); // After Login, User will be redirected to the Dashboard Page.
        });
        toast.success("Login Successful");
      })
      .catch((error) => {
        // Login Request Failed and promise returned ERROR !
        // console.error(
        //   "Login :  Login Request Failed !! Promise returned ERROR !"
        // );
        // console.log("ERROR", error.response.data);
        toast.error("Incorrect EmailId or Password");
      });
  };

  return sessionStorage.data ? (
    (toast.error("You Are Already Logged In !!"),
    (<Navigate to="/user/dashboard" />))
  ) : (
    <div className="main-container-login">
      <CustomNavBar></CustomNavBar>
      {/* Calling Submit Form Method once the user clicks the submit button at the end of the form */}
      <Form className="login-form" onSubmit={submitForm}>
        <h1>Login Here !</h1>
        <FormGroup floating>
          <Input
            id="emailId"
            name="emailId"
            placeholder="Email"
            type="email"
            // Performing Two Way Data binding Below For Email Id
            onChange={(event) => handleChange(event)} // Invoking handle change and saving my data in the Use State.
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
            // Performing Two Way Data binding Below For Password
            onChange={(event) => handleChange(event)} // Invoking handle change and saving my data in the Use State.
            value={data.password}
          />
          <Label for="password">Password</Label>
        </FormGroup>

        {/* Login and Reset Buttons */}

        <Button block color="primary" type="submit">
          Login
        </Button>
        <Button block color="danger" onClick={resetData}>
          Reset Data
        </Button>
      </Form>
      {/* <Footer/> */}
      <Footer />
    </div>
  );
};

export default Login;
