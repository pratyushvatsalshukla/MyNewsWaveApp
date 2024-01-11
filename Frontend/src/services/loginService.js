import { myAxios } from "./Helper";

export const logIn = (user)=>{
    // console.log("User in Service ", user) ;
    return myAxios.post('authorization/login',user)
    .then((response) => response.data) ;
    // JSON.stringify(response) pr response.data
}
