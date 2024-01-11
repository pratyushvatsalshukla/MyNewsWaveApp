import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { isLoggedIn } from "../authentication/CheckAuthentication";
import { toast } from "react-toastify";

const PrivateRoute = () => {

  return isLoggedIn() ? <Outlet /> : (toast.error("Please Login First"), <Navigate to={"/login"} />);
  
};

export default PrivateRoute;
