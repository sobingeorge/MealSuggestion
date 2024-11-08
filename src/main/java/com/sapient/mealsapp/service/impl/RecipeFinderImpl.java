package com.sapient.mealsapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.mealsapp.model.Address;
import com.sapient.mealsapp.model.DocumenuResponseModel;
import com.sapient.mealsapp.model.MenuItem;
import com.sapient.mealsapp.model.MenuRecommendation;
import com.sapient.mealsapp.model.ResponseDto;
import com.sapient.mealsapp.service.RecipeFinder;

@Component
public class RecipeFinderImpl implements RecipeFinder {
	
	
	@Value("${edamam.appId}")
	String apiId;
	
	@Value("${edamam.appKey}")
	String apiKey;
	
	@Value("${edamam.url}")
	String apiBaseUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	List newYorkFood = new ArrayList<>() {
		{
			add("Caesar Salad");
			add("Veg Sandwich");
		}
	};
	List mumbaiFood = new ArrayList<>() {
		{
			add("Vada paav");
			add("Sandwich");
		}
	};
	List commonFood = new ArrayList<>() {
		{
			add("Dates Shake");
			add("Pulses bowl");
		}
	};

	@Override
	public DocumenuResponseModel getRestaurantBasedOnCity(String city, String cuisine) {

		ResponseDto pojoclassObj = callEdamamAPI(city, cuisine);
		String recipe = null;
		String dish = null;
		if( null != pojoclassObj && null != pojoclassObj.getRecipe() && null != pojoclassObj.getRecipe().getIngredientLines()) {
			recipe = String.join(", ", pojoclassObj.getRecipe().getIngredientLines());
			dish = pojoclassObj.getRecipe().getLabel();
		}
		
		DocumenuResponseModel responseModel = DocumenuResponseModel.builder()
				.responseDto(MenuRecommendation.builder().address(Address.builder().city(city).build()).
						menuItem(MenuItem.builder().name(dish).recipe(recipe).build()).build()).build();
		
		return responseModel;

	}
	
	public ResponseDto callEdamamAPI(String city, String cuisine) {
		
		String url = apiBaseUrl + "recipes/v2/6d4e279e13860959642dd4d3ee4e6e17?type=public&app_id="
		+ apiId + "&app_key=" + apiKey;
		
		ResponseEntity<String> response2 = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		ObjectMapper mapper = new ObjectMapper();
		ResponseDto pojoclassObj = null;
		try {
			pojoclassObj = mapper.readValue(response2.getBody(), ResponseDto.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		return pojoclassObj;
		
	}

	/**
	 * Documenu registration is not available, so hardcoding
	 * 
	 * 
	 * 
	 * @Override public List getRestaurantBasedOnCity(String city) { OkHttpClient
	 *           client = new OkHttpClient(); Response resp = null; //Documenu
	 *           registration is not available, so hardcoding Request request = new
	 *           Request.Builder()
	 *           .url("https://documenu.p.rapidapi.com/restaurant/4072702673999819")
	 *           .get() .addHeader("x-rapidapi-key",
	 *           "71459800cbmsh49828baa473f9b8p10c90djsn304c78862ca0")
	 *           .addHeader("x-rapidapi-host", "documenu.p.rapidapi.com") .build();
	 * 
	 *           try { resp= client.newCall(request).execute(); if( null == resp ||
	 *           resp.code() != 200 ) { if(city.equalsIgnoreCase("new york")) {
	 *           return newYorkFood; }else if(city.equalsIgnoreCase("mumbai")) {
	 *           return mumbaiFood; }else { return commonFood; } } return null; }
	 *           catch (IOException e) { // TODO Auto-generated catch block
	 *           e.printStackTrace(); }
	 * 
	 *           }
	 */
}
