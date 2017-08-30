package com.stuff.learn.flights.bo;

public class FlightRequest {
	
	private String flightInfoFilePath;
	private String airportInfoFilePath;
	private int source;
	private int destination;
	private String date;
	
	public String getFlightInfoFilePath() {
		return flightInfoFilePath;
	}
	public void setFlightInfoFilePath(String flightInfoFilePath) {
		this.flightInfoFilePath = flightInfoFilePath;
	}
	public String getAirportInfoFilePath() {
		return airportInfoFilePath;
	}
	public void setAirportInfoFilePath(String airportInfoFilePath) {
		this.airportInfoFilePath = airportInfoFilePath;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
