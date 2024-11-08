import http from "../http-common";


const citySearch = data => {
  
  return http.get("/fetchRecommendation?city="+data.city+"&cuisineType="+data.cuisineType,  data);


};

export default {
  citySearch
};
