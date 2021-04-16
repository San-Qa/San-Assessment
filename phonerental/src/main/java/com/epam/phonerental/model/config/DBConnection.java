package com.epam.phonerental.model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.phonerental.util.PropertiesReader;

public class DBConnection {

	private static final Logger LOGGER = LogManager.getLogger();

private static final String PROPERTIES_DB_FILE = "src/main/resources/db/dbconnection.properties"; 		
private static final String URL = "jdbcUrl";
private static final String USER = "db.username";
private static final String PASSWORD = "db.password";
private static final String DRIVER = "driverClassName";

private String dataBaseUrl = "";
private String databaseUser = "";
private String databasePassword = "";
private String databaseDriver = "";

public DBConnection() {
	Properties properties = PropertiesReader.getProperties(PROPERTIES_DB_FILE);
	
	dataBaseUrl = properties.getProperty(URL);
	databaseUser = properties.getProperty(USER);
	databasePassword = properties.getProperty(PASSWORD);
	databaseDriver = properties.getProperty(DRIVER);
}

public Connection getConnection() {
	
	try {
		Class.forName(databaseDriver);
		
	return DriverManager.getConnection(dataBaseUrl, databaseUser, databasePassword);	
	}catch (SQLException e) {
		LOGGER.error("Unable to connect to database" + dataBaseUrl +" " + e);
	} catch (ClassNotFoundException e) {
		LOGGER.error("Unable to find to database driver" + dataBaseUrl +" " + e);
	}
	return null;
	}
}
