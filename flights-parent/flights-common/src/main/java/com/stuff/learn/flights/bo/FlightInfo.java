package com.stuff.learn.flights.bo;

public class FlightInfo {
	private String flightNumber;
	private int source;
	private int destination;
	private String sourceAirportName;
	private String destinationAirportName;
	private String weeklyScheduleInfo;
	private String timeOfday;

	public FlightInfo(String flightNumber, int source, int destination, String sourceAirportName,
			String destinationAirportName) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.sourceAirportName = sourceAirportName;
		this.destinationAirportName = destinationAirportName;
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

	public String getSourceAirportName() {
		return sourceAirportName;
	}

	public void setSourceAirportName(String sourceAirportName) {
		this.sourceAirportName = sourceAirportName;
	}

	public String getDestinationAirportName() {
		return destinationAirportName;
	}

	public void setDestinationAirportName(String destinationAirportName) {
		this.destinationAirportName = destinationAirportName;
	}

	public String getWeeklyScheduleInfo() {
		return weeklyScheduleInfo;
	}

	public void setWeeklyScheduleInfo(String weeklyScheduleInfo) {
		this.weeklyScheduleInfo = weeklyScheduleInfo;
	}

	public String getTimeOfday() {
		return timeOfday;
	}

	public void setTimeOfday(String timeOfday) {
		this.timeOfday = timeOfday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destination;
		result = prime * result + ((destinationAirportName == null) ? 0 : destinationAirportName.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + source;
		result = prime * result + ((sourceAirportName == null) ? 0 : sourceAirportName.hashCode());
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
		if (destinationAirportName == null) {
			if (other.destinationAirportName != null)
				return false;
		} else if (!destinationAirportName.equals(other.destinationAirportName))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (source != other.source)
			return false;
		if (sourceAirportName == null) {
			if (other.sourceAirportName != null)
				return false;
		} else if (!sourceAirportName.equals(other.sourceAirportName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightInfo [flightNumber=" + flightNumber + ", source=" + source + ", destination=" + destination
				+ ", sourceAirportName=" + sourceAirportName + ", destinationAirportName=" + destinationAirportName
				+ ", weeklyScheduleInfo=" + weeklyScheduleInfo + "]";
	}

}
