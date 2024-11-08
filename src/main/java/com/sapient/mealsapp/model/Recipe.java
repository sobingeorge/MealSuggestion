package com.sapient.mealsapp.model;

import java.util.List;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "uri", "label", "image", "images", "source", "url", "shareAs", "yield", "dietLabels",
		"healthLabels", "cautions", "ingredientLines", "ingredients", "calories", "totalCO2Emissions",
		"co2EmissionsClass", "totalWeight", "totalTime", "cuisineType", "mealType", "dishType", "totalNutrients",
		"totalDaily", "digest" })
@Generated("jsonschema2pojo")
//@JsonRootName(value="recipe")
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

	@JsonProperty("uri")
	private String uri;
	@JsonProperty("label")
	private String label;
	@JsonProperty("image")
	private String image;
	@JsonProperty("source")
	private String source;
	@JsonProperty("url")
	private String url;
	@JsonProperty("shareAs")
	private String shareAs;
	@JsonProperty("yield")
	private Integer yield;
	@JsonProperty("dietLabels")
	private List<String> dietLabels;
	@JsonProperty("healthLabels")
	private List<String> healthLabels;
	@JsonProperty("cautions")
	private List<String> cautions;
	@JsonProperty("ingredientLines")
	private List<String> ingredientLines;

	@JsonProperty("calories")
	private Double calories;
	@JsonProperty("totalCO2Emissions")
	private Double totalCO2Emissions;
	@JsonProperty("co2EmissionsClass")
	private String co2EmissionsClass;
	@JsonProperty("totalWeight")
	private Double totalWeight;
	@JsonProperty("totalTime")
	private Integer totalTime;
	@JsonProperty("cuisineType")
	private List<String> cuisineType;
	@JsonProperty("mealType")
	private List<String> mealType;
	@JsonProperty("dishType")
	private List<String> dishType;

}