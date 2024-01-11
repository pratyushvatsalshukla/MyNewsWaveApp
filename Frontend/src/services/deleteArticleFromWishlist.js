import axios from "axios";
import {
  getCurrentUserDetail,
  isLoggedIn,
} from "../authentication/CheckAuthentication";

let token = "" ;
let myAxios ;
const createAxios = () => {
    token =getCurrentUserDetail().token ;
    myAxios=axios.create({
        baseURL: "http://13.200.45.5:8085",
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
}

export const deleteArticleFromWishlist = (article) => {
    createAxios() ;
    // console.log("DELETE ARTICLE FROM WISHLIST AXIOS : ", article)
    return myAxios
    .delete('/wishlist/deleteWishlist',{ data: article }) 
    .then((response) => response.data);

};
