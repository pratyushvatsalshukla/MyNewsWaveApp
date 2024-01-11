import axios from "axios";

export const BASE_URL='http://13.200.45.5:8080/' ;
export const myAxios=axios.create(
    {
        baseURL:BASE_URL,
    }
) ;