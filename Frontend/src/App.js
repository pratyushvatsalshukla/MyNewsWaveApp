import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
// import Base from './components/Base';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./components/LandingPage/Home";
import Login from "./components/Login/Login";
import Signup from "./components/Signup/Signup";
import React from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { UserDashboard } from "./components/UserDashboard/UserDashboard";
import PrivateRoute from "./services/PrivateRoute";
import Wishlist from "./components/Wishlist/Wishlist";

function App() {
  return (
    <BrowserRouter>
      <ToastContainer
        position="bottom-right"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
      />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/user" element={<PrivateRoute />}>
          <Route path="dashboard" element={<UserDashboard />} />
          <Route path="wishlist" element={<Wishlist />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
