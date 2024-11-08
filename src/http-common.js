import axios from "axios";



const getAuthHeader = () =>{

const user = JSON.parse(localStorage.getItem('user'));
  
  if (user && user.accessToken) {
     return { Authorization: 'Bearer ' + user.accessToken }; // for Spring Boot back-end
  } else {
    return {};
  }
}

export default axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept, authorization",
    "Access-Control-Allow-Methods": "GET, POST, OPTIONS, PUT, DELETE"
  }
});
