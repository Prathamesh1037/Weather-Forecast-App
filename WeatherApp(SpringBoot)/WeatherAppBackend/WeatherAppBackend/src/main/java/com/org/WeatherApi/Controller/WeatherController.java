package com.org.WeatherApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.WeatherApi.Entity.Forecast;
import com.org.WeatherApi.Entity.Root;
import com.org.WeatherApi.Entity.WeatherApi;
import com.org.WeatherApi.Service.WeatherService;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {
        
	@Autowired 
	private WeatherService service;
	
	@GetMapping("/{city}")
	public String response (@PathVariable String city) {
		 return service.test();
	}
	
	@GetMapping("/my/{city}")
	public WeatherApi responseWeather (@PathVariable String city) {
		 return service.getData(city);
	}
	
	@GetMapping("/forecast")
	public Forecast getForeCast (@RequestParam String city , @RequestParam int days) {
		 return service.getforecast(city,days);
	}
}
