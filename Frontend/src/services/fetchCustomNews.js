import axios from "axios";
import {
  getCurrentUserDetail,
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

export const fetchCustomNews = (subject) => {
    createAxios() ;
    return myAxios
    .get(`newsService/${subject}`)
    .then((response) => response.data);

};
