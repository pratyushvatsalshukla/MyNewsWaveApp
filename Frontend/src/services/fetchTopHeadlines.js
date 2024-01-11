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

export const fetchTopHeadlines =  () => {
    createAxios() ;
    return  myAxios
    .post("/newsService/","")
    .then((response) => response.data);

};
