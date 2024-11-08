package com.sapient.mealsapp.model;

import java.util.ArrayList;
import java.util.Date;

import com.sapient.mealsapp.model.MenuItem.MenuItemBuilder;

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
public class MenuRecommendation {
	protected Address address;
	protected MenuItem menuItem;
	protected ArrayList<String> cuisines;
	protected Geo geo;
	protected String hours;
	protected Date last_updated;
	protected ArrayList<Menu> menus;
	protected String price_range;
	protected long restaurant_id;
	protected String restaurant_name;
	protected String restaurant_phone;
	protected String restaurant_website;
}