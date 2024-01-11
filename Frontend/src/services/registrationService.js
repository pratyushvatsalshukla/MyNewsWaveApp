import { myAxios } from "./Helper";

export const signUp = (user)=>{
    console.log("User in Signup Service", user) ;
    return myAxios.post('newsWave/registration', user)
    .then((response) => response.data) ;
    // JSON.stringify(response) pr response.data
}

// export const logIn = (user)=>{
//     return myAxios.get('/authorization/login',user)
//     .then((response) => response.data) ;
//     // JSON.stringify(response) pr response.data
// }