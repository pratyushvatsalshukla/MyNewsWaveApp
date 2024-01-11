import axios from "axios";
import { getCurrentUserDetail } from "../authentication/CheckAuthentication";
let token = "" ;
let myAxios ;
const createAxios = () => {
    token =getCurrentUserDetail()?.token ;
    myAxios=axios.create({
        baseURL: "http://localhost:8080",
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
}

const getUserByEmail =(emailId) => {
    createAxios() ;
    return myAxios.get(`newsWave/getUserById/${emailId}`)
    .then((response)=> response.data) ;
}

export default getUserByEmail ;
