package com.org.WeatherApi.Entity;

import java.time.LocalDate;

public class DayTemp {
   public String localdate;
   
   public Double min_temp;
   
   public Double avg_temp;
   
   public Double max_temp;

   
   public DayTemp() {
	   
   }
   public DayTemp(String localdate, Double min_temp, Double avg_temp, Double max_temp) {
	super();
	this.localdate = localdate;
	this.min_temp = min_temp;
	this.avg_temp = avg_temp;
	this.max_temp = max_temp;
   }

   public String getLocaldate() {
	return localdate;
   }

   public void setLocaldate(String localdate) {
	this.localdate = localdate;
   }

   public Double getMin_temp() {
	return min_temp;
   }

   public void setMin_temp(Double min_temp) {
	this.min_temp = min_temp;
   }

   public Double getAvg_temp() {
	return avg_temp;
   }

   public void setAvg_temp(Double avg_temp) {
	this.avg_temp = avg_temp;
   }

   public Double getMax_temp() {
	return max_temp;
   }

   public void setMax_temp(Double max_temp) {
	this.max_temp = max_temp;
   }
   
}
