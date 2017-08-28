package com.stuff.learn.flights.utils;

import java.util.function.Predicate;

import com.stuff.learn.flights.bo.FlightInfo;

public class FlightInfoPredicate {
	
	public static Predicate<FlightInfo> isRouteExactFlight(int source,  int destination){
		return p -> p.getSource() == source && p.getDestination() == destination;
	}
	
	public static Predicate<FlightInfo> isRouteFlight(int source,  int destination){
		return p -> source == p.getSource()  || destination == p.getDestination();
	}

}
