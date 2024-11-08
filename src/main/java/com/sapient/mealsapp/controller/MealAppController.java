package com.sapient.mealsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.mealsapp.model.DocumenuResponseModel;
import com.sapient.mealsapp.service.RecipeFinder;



@CrossOrigin(
	    origins = {
	        "http://localhost:3000"
	        },
	    methods = {
	                RequestMethod.OPTIONS,
	                RequestMethod.GET,
	                RequestMethod.PUT,
	                RequestMethod.DELETE,
	                RequestMethod.POST
	})

@RestController
public class MealAppController {
	

	
	@Autowired
	RecipeFinder recipeFinder;
	
	
	@GetMapping("/healthCheck" )
	public String testing() {
		return "Its up";
	}
	
	@GetMapping("/fetchRecommendation" )
	public DocumenuResponseModel fetchRecommendation( @RequestParam String city, @RequestParam(required = false) String cuisineType) {
		return recipeFinder.getRestaurantBasedOnCity(city, cuisineType);
		//return apiCallHeader;
	}
	
	

}
