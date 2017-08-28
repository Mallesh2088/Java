package com.stuff.learn.flights.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

	public Stream<String> readFile(String filePath) throws IOException {
		Stream<String> stream = Files.lines(Paths.get(filePath));
		return stream;
	}
}
