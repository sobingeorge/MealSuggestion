package com.sapeint.mealsapp.demo;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.sapient.mealsapp.model.ResponseDto;
import com.sapient.mealsapp.service.impl.RecipeFinderImpl;



public class RecipeFinderImplTest {

	@InjectMocks
	RecipeFinderImpl service;
	
	@Mock
	RestTemplate restTemplate;
	
	String mockResponse = "{\"recipe\":{\"label\":\"3 P.M. Salad\",\"ingredientLines\": [\r\n"
			+ "      \"For a single serving of salad:\",\r\n"
			+ "      \"1 big handful baby kale\",\r\n"
			+ "      \"2 radishes, thinly sliced into rounds and then halved\",\r\n"
			+ "      \"1 egg\",\r\n"
			+ "      \"For dressing (makes about 1/2 cup, enough for 4 to 5 servings of salad):\",\r\n"
			+ "      \"1 cup packed torn basil leaves\",\r\n"
			+ "      \"1/4 cup olive oil\",\r\n"
			+ "      \"juice of a small lemon\",\r\n"
			+ "      \"1/2 cup cooked white beans (I used navy)\",\r\n"
			+ "      \"2 large cloves garlic, roughly chopped\",\r\n"
			+ "      \"salt and fresh ground pepper\"\r\n"
			+ "    ]}}";
	
	@Test
	public void testEdamamResponse() {
		
		when(restTemplate.exchange(anyString(), HttpMethod.GET, null, String.class)).
		thenReturn(new ResponseEntity<String>(mockResponse, null));
		ResponseDto response = service.callEdamamAPI("mumbai", "american");
		Assert.notNull(response, "Should be populated");
	}
	
}
