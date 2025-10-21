package com.org.WeatherApi.Entity;

public class AirQuality{
    public double co;
    public double no2;
    public int o3;
    public double so2;
    public double pm2_5;
    public double pm10;
    public int us_epa_index;
    public int gb_defra_index;
    
    public AirQuality() {
    	
    }

	public AirQuality(double co, double no2, int o3, double so2, double pm2_5, double pm10, int us_epa_index,
			int gb_defra_index) {
		super();
		this.co = co;
		this.no2 = no2;
		this.o3 = o3;
		this.so2 = so2;
		this.pm2_5 = pm2_5;
		this.pm10 = pm10;
		this.us_epa_index = us_epa_index;
		this.gb_defra_index = gb_defra_index;
	}

	public double getCo() {
		return co;
	}

	public void setCo(double co) {
		this.co = co;
	}

	public double getNo2() {
		return no2;
	}

	public void setNo2(double no2) {
		this.no2 = no2;
	}

	public int getO3() {
		return o3;
	}

	public void setO3(int o3) {
		this.o3 = o3;
	}

	public double getSo2() {
		return so2;
	}

	public void setSo2(double so2) {
		this.so2 = so2;
	}

	public double getPm2_5() {
		return pm2_5;
	}

	public void setPm2_5(double pm2_5) {
		this.pm2_5 = pm2_5;
	}

	public double getPm10() {
		return pm10;
	}

	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}

	public int getUs_epa_index() {
		return us_epa_index;
	}

	public void setUs_epa_index(int us_epa_index) {
		this.us_epa_index = us_epa_index;
	}

	public int getGb_defra_index() {
		return gb_defra_index;
	}

	public void setGb_defra_index(int gb_defra_index) {
		this.gb_defra_index = gb_defra_index;
	}
    
    
}
