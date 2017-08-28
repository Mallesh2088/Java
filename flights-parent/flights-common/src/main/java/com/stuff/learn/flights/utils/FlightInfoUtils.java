package com.stuff.learn.flights.utils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stuff.learn.flights.bo.FlightInfo;

public class FlightInfoUtils {
	
	public static List<FlightInfo> getFlightInfo(String filePath) {
		FileUtils fileUtils = new FileUtils();
		List<FlightInfo> flightInfos = null;
		try (Stream<String> fileStream = fileUtils.readFile(filePath)) {
			flightInfos = fileStream.map(string -> string.split("\\|"))
					.map(array -> new FlightInfo(array[0], Integer.valueOf(array[1]), Integer.valueOf(array[2])))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightInfos;
	}

}
