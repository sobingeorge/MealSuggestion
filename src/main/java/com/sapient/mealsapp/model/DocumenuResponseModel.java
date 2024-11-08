package com.sapient.mealsapp.model;

import java.util.ArrayList;

import com.sapient.mealsapp.model.MenuRecommendation.MenuRecommendationBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumenuResponseModel {
	protected MenuRecommendation responseDto;
}


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 class MenuSection{
 public String description;
 public ArrayList<MenuItem> menu_items;
 public String section_name;
}


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 class Pricing{
 public String currency;
 public double price;
 public String priceString;
}




