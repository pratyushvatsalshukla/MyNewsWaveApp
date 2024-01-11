import axios from "axios";
import { getCurrentUserDetail } from "../authentication/CheckAuthentication";

let token = "" ;
let myAxios ;
const createAxios = () => {
    token =getCurrentUserDetail().token ;
    myAxios=axios.create({
        baseURL: "http://localhost:8080",
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
}

export const getUserWishlist = (emailId) => {
    createAxios() ;
    console.log("TOken in getUserWishlist" ,token) ;
    return myAxios.get(`newsWave/getUserById/${emailId}`)
    .then((response)=> response.data) ;
}

