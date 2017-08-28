package com.stuff.learn.flights.bo;

public class FlightInfo {
	private String flightNumber;
	private int source;
	private int destination;

	public FlightInfo(String flightNumber, int source, int destination) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
	}
	
	public FlightInfo() {
		super();
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destination;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + source;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightInfo other = (FlightInfo) obj;
		if (destination != other.destination)
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (source != other.source)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightInfo [flightNumber=" + flightNumber + ", source=" + source + ", destination=" + destination + "]";
	}

}
