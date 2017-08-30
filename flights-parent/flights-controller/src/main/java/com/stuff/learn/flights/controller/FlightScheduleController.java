package com.stuff.learn.flights.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stuff.learn.flights.bo.FlightInfo;
import com.stuff.learn.flights.bo.FlightRequest;
import com.stuff.learn.flights.utils.FlightInfoPredicate;
import com.stuff.learn.flights.utils.FlightInfoUtils;

public class FlightScheduleController {

	public static void main(String[] args) {
		String flightInfoFilePath = "C:\\Mallesh\\Learning\\Flights\\Flights_DB.txt";
		String airportInfoFilePath = "C:\\Mallesh\\Learning\\Flights\\Airports_DB.txt";
		FlightRequest flightRequest = new FlightRequest();
		flightRequest.setFlightInfoFilePath(flightInfoFilePath);
		flightRequest.setAirportInfoFilePath(airportInfoFilePath);
		flightRequest.setSource(1);
		flightRequest.setDestination(4);
		flightRequest.setDate("29/08/2017");
		FlightScheduleController flightScheduleController = new FlightScheduleController();
		List<FlightInfo> flightSchedule = flightScheduleController.getFlightSchedule(flightRequest);

		FlightRequest flightRequestForDestination = new FlightRequest();
		flightRequestForDestination.setFlightInfoFilePath(flightInfoFilePath);
		flightRequestForDestination.setAirportInfoFilePath(airportInfoFilePath);
		flightRequestForDestination.setSource(2);
		flightRequestForDestination.setDestination(8);
		flightRequestForDestination.setDate("29/08/2017");
		List<FlightInfo> flightSchedules = flightScheduleController
				.getFlightScheduleForSourceDestination(flightRequestForDestination);
	}

	public List<FlightInfo> getFlightSchedule(FlightRequest flightRequest) {
		Map<Integer, String> airportInfos = FlightInfoUtils.getAirportInfo(flightRequest.getAirportInfoFilePath());
		List<FlightInfo> flightInfos = FlightInfoUtils.getFlightInfo(flightRequest.getFlightInfoFilePath(),
				airportInfos);
		List<FlightInfo> filteredFlightInfos = flightInfos.stream().filter(
				FlightInfoPredicate.isRouteExactFlight(flightRequest.getSource(), flightRequest.getDestination()))
				.collect(Collectors.toList());
		List<FlightInfo> filterResultsBasedOnScheduleInfo = filterResultsBasedOnScheduleInfo(flightRequest,
				filteredFlightInfos);
		System.out.println("---Route Exact Flight---");
		if(filterResultsBasedOnScheduleInfo.isEmpty()) {
			System.out.println("No Flights for the selected criteria");
		} else {
			filterResultsBasedOnScheduleInfo.forEach(System.out::println);
		}
		
		return filterResultsBasedOnScheduleInfo;

	}

	private List<FlightInfo> filterResultsBasedOnScheduleInfo(FlightRequest flightRequest,
			List<FlightInfo> filteredFlightInfos) {
		int dayInfo = FlightInfoUtils.getDayInfofromString(flightRequest.getDate());
		Iterator<FlightInfo> flightInfoIterator = filteredFlightInfos.iterator();
		while (flightInfoIterator.hasNext()) {
			FlightInfo flightInfo = flightInfoIterator.next();
			if (flightInfo.getWeeklyScheduleInfo().charAt(dayInfo) == '0') {
				flightInfoIterator.remove();
			}
		}
		return filteredFlightInfos;
	}


	public List<FlightInfo> getFlightScheduleForSourceDestination(FlightRequest flightRequest) {
		Map<Integer, String> airportInfos = FlightInfoUtils.getAirportInfo(flightRequest.getAirportInfoFilePath());
		List<FlightInfo> flightInfos = FlightInfoUtils.getFlightInfo(flightRequest.getFlightInfoFilePath(),
				airportInfos);
		List<FlightInfo> filteredFlightInfos = flightInfos.stream()
				.filter(FlightInfoPredicate.isRouteFlight(flightRequest.getSource(), flightRequest.getDestination()))
				.collect(Collectors.toList());
		List<FlightInfo> filterResultsBasedOnScheduleInfo = filterResultsBasedOnScheduleInfo(flightRequest, filteredFlightInfos);
		System.out.println("---Route Flight---");
		filterResultsBasedOnScheduleInfo.forEach(System.out::println);
		return filterResultsBasedOnScheduleInfo;
	}
}
