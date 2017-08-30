package com.stuff.learn.flights.utils;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stuff.learn.flights.bo.FlightInfo;

public class FlightInfoUtils {

	public static List<FlightInfo> getFlightInfo(String filePath, Map<Integer, String> airportInfos) {
		FileUtils fileUtils = new FileUtils();
		List<FlightInfo> flightInfos = null;
		try (Stream<String> fileStream = fileUtils.readFile(filePath)) {
			flightInfos = fileStream.map(string -> string.split("\\|"))
					.map(array -> mapFlightInfo.apply(array, airportInfos)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightInfos;
	}

	public static Map<Integer, String> getAirportInfo(String filePath) {
		FileUtils fileUtils = new FileUtils();
		Map<Integer, String> airportInfos = null;
		try (Stream<String> fileStream = fileUtils.readFile(filePath)) {
			airportInfos = fileStream.map(string -> string.split("\\|"))
					.collect(Collectors.toMap(array -> Integer.valueOf(array[1]), array -> String.valueOf(array[0])));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return airportInfos;
	}

	static BiFunction<String[], Map<Integer, String>, FlightInfo> mapFlightInfo = new BiFunction<String[], Map<Integer, String>, FlightInfo>() {

		@Override
		public FlightInfo apply(String[] array, Map<Integer, String> airportInfos) {
			FlightInfo flightInfo = new FlightInfo();
			flightInfo.setFlightNumber(array[0]);
			flightInfo.setSource(Integer.valueOf(array[1]));
			flightInfo.setDestination(Integer.valueOf(array[2]));
			flightInfo.setWeeklyScheduleInfo(array[3]);
			flightInfo.setSourceAirportName(airportInfos.get(flightInfo.getSource()));
			flightInfo.setDestinationAirportName(airportInfos.get(flightInfo.getDestination()));
			flightInfo.setTimeOfday(array[4]);
			return flightInfo;
		}
	};

	public static int getDayInfofromString(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		return dayOfWeek.getValue();
	}
	
	public static boolean compareTimeOfDay(String time1, String time2) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(time1, dateTimeFormatter);
		LocalTime localTime2 = LocalTime.parse(time2, dateTimeFormatter);
		return localTime.isBefore(localTime2);
	}

}
