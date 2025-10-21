package com.org.WeatherApi.Entity;

public class WeatherApi {
   private String city;
   
   private String condition;
   
   private double temperature;
   
   private String region;
   
   private String country;
   
   
   public WeatherApi() {
	   
   }


   public WeatherApi(String city, String condition, double temperature, String region, String country) {
	super();
	this.city = city;
	this.condition = condition;
	this.temperature = temperature;
	this.region = region;
	this.country = country;
   }


   public String getCity() {
	return city;
   }


   public void setCity(String city) {
	this.city = city;
   }


   public String getCondition() {
	return condition;
   }


   public void setCondition(String condition) {
	this.condition = condition;
   }


   public double getTemperature() {
	return temperature;
   }


   public void setTemperature(double temperature) {
	this.temperature = temperature;
   }


   public String getRegion() {
	return region;
   }


   public void setRegion(String region) {
	this.region = region;
   }


   public String getCountry() {
	return country;
   }


   public void setCountry(String country) {
	this.country = country;
   }

  
   
}
