import React, { useState, useEffect } from "react";
import { NavLink as ReactLink } from "react-router-dom";
import "./CustomNavBar.css";
import { useNavigate } from "react-router-dom";
import { Form, FormGroup, Input, Label } from "reactstrap";
import { updateUserService } from "../../services/updateUserService";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  Button,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter,
} from "reactstrap";
import favicon from "../resources/favicon.ico";
import {
  doLogout,
  getCurrentUserDetail,
  isLoggedIn,
} from "../../authentication/CheckAuthentication";
import { toast } from "react-toastify";
import getUserByEmail from "../../services/getUserById";

const CustomNavBar = (props) => {
  const navigate = useNavigate();
  const navigateHome = () => navigate("/");
  const [isOpen, setIsOpen] = useState(false); //  For Modal Collapse : Refer line 108
  const [modal, setModal] = useState(false); // For Modal
  const [login, setLogin] = useState(false); // To Set Login and Logout Values.
  const [user, setUser] = useState({
    emailId: "",
    name: "",
  });
  const [data, setData] = useState({
    // This is for the user Update Method. He can update his name by only after entering wrong password.
    name: "",
    password: "",
  });

  //This Use Effect will be called only once, when the component is going to be loaded for the first time.
  useEffect(() => {
    setLogin(isLoggedIn());
    getUserByEmail(getCurrentUserDetail()?.emailId).then((response) => {
      // parsing the Data from session Storage and the setting a new Field "name" which we'll get by calling getuserByEmail method.
      const data = JSON.parse(sessionStorage.getItem("data"));
      // Update the specific item in the data
      data.name = response.name;
      // Save the updated data back to sessionStorage
      sessionStorage.setItem("data", JSON.stringify(data));
      //Setting the Current user with the values of Session Storage.
      setUser(getCurrentUserDetail());
    }).catch((error) => {
    }) ;
  }, []);

  const getWishlist = () => {
    // console.info("Navigating to Wishlist") ;
    navigate("/user/wishlist"); // Navigating to /user/wishlist once user clicks on wishlist.
  };

  const getDashboard = () => {
    // console.info("Navigating to User Dashboard") ;
    navigate("/user/dashboard"); // Navigating to /user/dashboard once user clicks on dashboard.
  };

  const logout = () => {
    doLogout(() => {
      // console.warn("Logging Out !!")
      toast.warn("Logged Out Successfully !!");
      // setLogin(false);
      // setUser(undefined);
      sessionStorage.clear();
      // navigateLogin(); // Callback for redirect to some page after logout
      navigateHome(); // Callback for redirect to some page after logout
    });
  };
  const toggle = () => setIsOpen(!isOpen); // Toggling navbar. setting open

  const update = () => {
    setModal(!modal); // Toggling the modal.
  };

  const handleChange = (event) => {
    // Setting the data to the usestate hooks.
    setData({ ...data, [event.target.name]: event.target.value });
  };

  // For To Update the User Data.
  const submitForm = (event) => {
    // console.info("Submitting Update Form : " + data.name);
    event.preventDefault();
    data.emailId = getCurrentUserDetail().emailId; //     adding emailId field to the data (JSON)

    updateUserService(data) // Calling update User Servce which will either return response if promise is true else error.
      .then((response) => {
        setModal(!modal);
        // console.info("User Updated Successfully !!");
        toast.success("Profile Updated Successfully !!");
      })
      .catch((error) => {
        // console.error("Profile Update Failed !! ReCheck Name and Password") ;
        toast.error("Profile Update Failed !! ReCheck Name and Password");
      });
  };

  

  return (
    <div>
      <Navbar color="dark" dark expand="md" className="custom-nav-bar">
        {/* Navigation Bar Logo */}
        <NavbarBrand href="/" className="NavHeader">
          <span className="logo-text">
            <img src={favicon} alt="NewsWave" className="logo"/> NewsWave
          </span>
        </NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          {/* Conditional Rendering Below  For Logged In User and Not Logged In User.*/}

          {login && (
            <>
              <Nav className="me-auto" navbar>
                <NavItem>
                  <NavLink className="nav-item-link"></NavLink>
                </NavItem>
                <NavItem>
                  <NavLink className="nav-item-link"></NavLink>
                </NavItem>
                <NavItem>
                  <NavLink className="nav-item-link"></NavLink>
                </NavItem>
              </Nav>
              <Nav navbar>
                <NavItem>
                  <NavLink className="nav-item">{user.name}</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink className="nav-item-link" onClick={getDashboard}>
                    Dashboard 
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink className="nav-item-link" onClick={getWishlist}>
                    Wishlist
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink className="nav-item-link" onClick={update}>
                    Update 
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink onClick={logout} className="nav-item-link nav-item-link-del">
                    LogOut 
                  </NavLink>
                </NavItem>
              </Nav>
            </>
          )}

          {/* Modal For User Update */}
          <Modal isOpen={modal} toggle={update} className="modal-style">
            <ModalHeader toggle={update} className="model-header">
              Update User Details
            </ModalHeader>
            <ModalBody>
              <Form className="login-form" onSubmit={submitForm}>
                <FormGroup floating>
                  <Input
                    id="name"
                    name="name"
                    placeholder="name"
                    type="text"
                    onChange={(event) => handleChange(event)} // Handle Change method to save the user entered data to UseState Variable.
                    value={data.text}
                  />
                  <Label for="name">New Name</Label>
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
                  <Label for="password">Your Password</Label>
                </FormGroup>
                <Button block color="primary" type="submit">
                  Update Data
                </Button>
              </Form>
              {/* <Footer/> */}
            </ModalBody>
            <ModalFooter className="modal-footer">
              {/* <Button color="secondary" onClick={update}> */}
              Login Again To See The Updated Data
              {/* </Button> */}
            </ModalFooter>
          </Modal>
          {!login && (
            <>
              <Nav className="me-auto" navbar></Nav>

              <Nav navbar>
                <NavItem>
                  <NavLink tag={ReactLink} to="/signup">
                    SignUp 📝
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink tag={ReactLink} to="/login">
                    Login 👤
                  </NavLink>
                </NavItem>
              </Nav>
            </>
          )}
        </Collapse>
      </Navbar>
    </div>
  );
};

export default CustomNavBar;
