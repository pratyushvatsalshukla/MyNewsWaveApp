import axios from "axios";
// import { useState } from "react";
import {
  getCurrentUserDetail,
  isLoggedIn,
} from "../authentication/CheckAuthentication";

let token = "" ;
let myAxios ;
const createAxios = () => {
    token =getCurrentUserDetail().token ;
    myAxios=axios.create({
        baseURL: "http://13.200.45.5:8080",
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
}

export const updateUserService = (updateData) => {
    createAxios() ;
    // console.log(" UPDATE USER SERVICE AXIOS", updateData)
    return myAxios
    .put('newsWave/updateDetails',updateData) 
    .then((response) => response.data);

};
