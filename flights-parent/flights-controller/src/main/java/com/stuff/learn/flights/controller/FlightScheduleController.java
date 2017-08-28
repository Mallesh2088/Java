package com.stuff.learn.flights.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.stuff.learn.flights.bo.FlightInfo;
import com.stuff.learn.flights.utils.FlightInfoPredicate;
import com.stuff.learn.flights.utils.FlightInfoUtils;

public class FlightScheduleController {

	public static void main(String[] args) {
		String filePath = "C:\\Mallesh\\Learning\\Flights\\Flights_DB.txt";
		FlightScheduleController flightScheduleController = new FlightScheduleController();
		//List<FlightInfo> flightSchedule = flightScheduleController.getFlightSchedule(filePath,1,4);
		List<FlightInfo> flightSchedule = flightScheduleController.getFlightScheduleForSourceDestination(filePath,2,8);
	}

	public List<FlightInfo> getFlightSchedule(String filePath,int source,int destination) {
		List<FlightInfo> flightInfos = FlightInfoUtils.getFlightInfo(filePath);
		List<FlightInfo> filteredFlightInfos = flightInfos.stream().filter(FlightInfoPredicate.isRouteExactFlight(source, destination)).collect(Collectors.toList());
		filteredFlightInfos.forEach(System.out::println);
		return filteredFlightInfos;

	}
	
	public List<FlightInfo> getFlightScheduleForSourceDestination(String filePath,int source,int destination) {
		List<FlightInfo> flightInfos = FlightInfoUtils.getFlightInfo(filePath);
		List<FlightInfo> filteredFlightInfos = flightInfos.stream().filter(FlightInfoPredicate.isRouteFlight(source, destination)).collect(Collectors.toList());
		filteredFlightInfos.forEach(System.out::println);
		return filteredFlightInfos;

	}
}
