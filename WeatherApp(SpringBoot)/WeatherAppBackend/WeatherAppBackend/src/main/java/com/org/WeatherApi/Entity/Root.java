package com.org.WeatherApi.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    public Location location;
    public Current current;
    @JsonProperty("forecast") 
    private Forecast_new forecast;
    
    



    public Forecast_new getForecast() {
        return forecast;
    }

    public void setForecast(Forecast_new forecast) {
        this.forecast = forecast;
    }



	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public Current getCurrent() {
		return current;
	}


	public void setCurrent(Current current) {
		this.current = current;
	}
    
    
}

