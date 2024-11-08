package com.sapient.mealsapp.service;

import com.sapient.mealsapp.model.DocumenuResponseModel;

public interface RecipeFinder {
	
	DocumenuResponseModel getRestaurantBasedOnCity(String city, String cuisine);
}
