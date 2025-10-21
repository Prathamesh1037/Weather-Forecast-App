package com.org.WeatherApi.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Forecast {
      public WeatherApi weatherApi;
	  public List<DayTemp> daytemp;
	  
	  public WeatherApi getWeatherApi() {
		  return weatherApi;
	  }
	  public void setWeatherApi(WeatherApi weatherApi) {
		  this.weatherApi = weatherApi;
	  }
	  public List<DayTemp> getDaytemp() {
		  return daytemp;
	  }
	  public void setDaytemp(List<DayTemp> daytemp) {
		  this.daytemp = daytemp;
	  }

	  
}
