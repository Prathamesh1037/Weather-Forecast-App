package com.org.WeatherApi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.WeatherApi.Entity.Day;
import com.org.WeatherApi.Entity.DayTemp;
import com.org.WeatherApi.Entity.ForeCastDay;
import com.org.WeatherApi.Entity.Forecast;
import com.org.WeatherApi.Entity.Forecast_new;
import com.org.WeatherApi.Entity.Root;
import com.org.WeatherApi.Entity.WeatherApi;

@Service
public class WeatherService {
	@Value("${weather.api.key}")
	public String key;
	
	@Value("${weather.api.url}")
	public String url;
	
	@Value("${weather.api.forecast.url}")
	public String forecasturl;
	
 RestTemplate restTemplate = new RestTemplate();
      public String test() {
    	  return "good";
      }
      
      public WeatherApi getData(String city) {
    	  
    	  String api = url+"?key="+key+"&q="+city;
    	  
    	 Root response = restTemplate.getForObject(api, Root.class);
    	 WeatherApi weatherResponse = new WeatherApi();
    	 weatherResponse.setCity(response.getLocation().name);
    	 String condition=response.getCurrent().getCondition().getText();
    	 weatherResponse.setCondition(condition);
    	 weatherResponse.setTemperature(response.getCurrent().temp_c);
    	 weatherResponse.setRegion(response.getLocation().region);
    	 weatherResponse.setCountry(response.getLocation().country);
    	 
    	 
    	 return weatherResponse;
    	  
      }
      public Forecast getforecast(String city, int days) {
    	  
    	  String forecasturl1 = forecasturl+"?key="+key+"&q="+city+"&days="+days;
    	  List<DayTemp> daylist = new ArrayList<>();
    	  WeatherApi weatherResponse = getData(city);
    	  Forecast forecast = new Forecast();
    	  Forecast response = new Forecast();
    	  response.setWeatherApi(weatherResponse);
    	  Root forecastresponse = restTemplate.getForObject(forecasturl1, Root.class);
    	  Forecast_new forecastnew = forecastresponse.getForecast();
    	  try {
			System.out.println(new ObjectMapper().writeValueAsString(forecastresponse));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  ArrayList<ForeCastDay> forecastday = forecastnew.getForecastday();
    	  for(ForeCastDay rs : forecastday) {
    		  DayTemp d = new DayTemp();
    		  d.setLocaldate(rs.getDate());
    		  d.setMin_temp(rs.getDay().mintemp_c);
    		  d.setMax_temp(rs.getDay().maxtemp_c);
    		  d.setAvg_temp(rs.getDay().avgtemp_c);
    		  daylist.add(d);
    	  }
    	  response.setDaytemp(daylist);
    	  
    	  return response;
    	
    	  
      }

}
