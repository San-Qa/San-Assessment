package com.epam.phonerental.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesReader {

	public static final Logger LOGGER = LogManager.getLogger();

	public static Properties getProperties(String filePath) {
		Properties properties = new Properties();
		try (FileInputStream inputStrem = new FileInputStream(filePath)) {
			properties.load(inputStrem); 
			LOGGER.info("Done reading from file"+ filePath);
		
		} catch (FileNotFoundException e) {
			LOGGER.error("Error not able to read from file" + filePath + e);

		} catch (IOException e) {
			LOGGER.error("Error while reading from file" + filePath + e);
		}

		return properties;
	}
}
