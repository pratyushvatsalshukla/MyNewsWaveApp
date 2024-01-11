export const doLogin=(data,next)=>{
    // localStorage.setItem("data",JSON.stringify(data)) ;// for remember me functionality
    sessionStorage.setItem("data",JSON.stringify(data)) ; 
    // console.info("Login Successful !!")
    next(); // Callback for redirect to some page after Login
}

export const isLoggedIn = () => {
    // return localStorage.getItem("data") ? true : false; // for remember me functionality
    return sessionStorage.getItem("data") ? true : false; 
}

export const doLogout = (next) => {
    // localStorage.removeItem("data");// for remember me functionality
    // console.warn("Check Authentication : doLogOut : LoggingOut")
    sessionStorage.removeItem("data"); 
    next() ; // Callback for redirect to some page after logout
}

export const getCurrentUserDetail =()=>{

    // return isLoggedIn() ? JSON.parse(localStorage.getItem("data")) : undefined; // for remember me functionality
    // console.warn("Check Authentication : getCurrentUserdetail() : Getting Current User Details.")

    return isLoggedIn() ? JSON.parse(sessionStorage.getItem("data")) : undefined;
}
