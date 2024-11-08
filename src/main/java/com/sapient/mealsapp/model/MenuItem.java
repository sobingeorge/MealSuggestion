package com.sapient.mealsapp.model;

import java.util.ArrayList;

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
public class MenuItem{
 public String description;
 public String name;
 public String recipe;
 public ArrayList<Pricing> pricing;
}