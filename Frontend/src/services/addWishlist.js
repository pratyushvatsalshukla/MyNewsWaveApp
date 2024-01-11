import axios from "axios";
import { useState } from "react";
import {
  getCurrentUserDetail,
  isLoggedIn,
} from "../authentication/CheckAuthentication";

let token = "" ;
let myAxios ;
const createAxios = () => {
    token =getCurrentUserDetail().token ;
    myAxios=axios.create({
        baseURL: "http://localhost:8085",
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
}

export const addArticleToWishlist = (article) => {
    createAxios() ;
    return myAxios
    .post('wishlist/save',article) 
    .then((response) => response.data);

};
