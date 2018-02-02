package com.learning.java8.dto;

public class Address {
	
	private String streetName;
	private String cityName;
	private String state;
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", cityName=" + cityName + ", state=" + state + "]";
	}

}
