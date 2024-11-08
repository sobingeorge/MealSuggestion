package com.sapient.mealsapp.model;

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
public class Address{
 public String city;
 public String formatted;
 public String postal_code;
 public String state;
 public String street;
}