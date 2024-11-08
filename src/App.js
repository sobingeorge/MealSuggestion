import React, {useState, useEffect} from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import RecipeService from "./services/RecipeService";


const App = props => {


  const initialState = {
    id: null,
    city: "",
    description: ""
  };

  const initialCityState = {
    id: null,
    name: ""
  };
  const [searchParam, setSearchParam] = useState(initialState);
  const [currentIndex, setCurrentIndex] = useState(-1);
  const [citySearch, setCitySearch] = useState(initialCityState);
  const [searchResults, setSearchResults] = useState([]);
  const [currentCity, setCurrentCity] = useState(null);
  const handleInputChange = event => {
    const { name, value } = event.target;
    setSearchParam({ ...searchParam, [name]: value });
  };

  const searchByCity = () => {
    var data = {
      city: searchParam.city,
      cuisineType: searchParam.cuisine
    };
    RecipeService.citySearch(data)
      .then(response => {
        setCitySearch({
          id: response.data.id,
          name: response.data.responseDto.address.city,
          dish: response.data.responseDto.menuItem.name,
          recipe: response.data.responseDto.menuItem.recipe
        });
        console.log();
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
      
  };


  const refreshList = () => {
    setCurrentCity(null);
    setCurrentIndex(-1);
  };

  

  return (
    <div>
    

<div className="list row">
<div className="col-md-8">
  <div className="input-group mb-3">
    <input
      type="text"
      className="form-control"
      placeholder="Search by city"
      id="title"
      name="city"
      value={searchParam.city}
      onChange={handleInputChange}
    />
    <input
      type="text"
      className="form-control"
      placeholder="Search by cuisine"
      id="title"
      name="cuisine"
      value={searchParam.cuisine}
      onChange={handleInputChange}
    />
    <div className="input-group-append">
      <button
        className="btn btn-outline-secondary"
        type="button"
        onClick={searchByCity}
      >
        Search
      </button>
    </div>
  </div>
  <div>
    {citySearch &&
    <table className="table table-hover">
      <tbody>
      <tr>
        <th>City</th>
        <th>Dish</th>
        <th>Recipe</th>
        
        </tr>
        <tr>
          <td>{citySearch && citySearch.name}</td>
          <td>{citySearch && citySearch.dish}</td>
          <td>{citySearch && citySearch.recipe}</td>
          </tr>
          </tbody>
      </table>
}
</div>

</div>


</div>


</div>
  );
};



export default App;
