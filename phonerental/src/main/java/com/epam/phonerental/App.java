package com.epam.phonerental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.epam.phonerental.model.config.DBConnection;
import com.epam.phonerental.util.PropertiesReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
    	
    	Properties properties = PropertiesReader.getProperties("src/main/resources/db/dbconnection.properties");
    	
    	System.out.println("File Lenght" + properties.size());
    	System.out.println("jdbcUrl: " + properties.getProperty("jdbcUrl"));
    	
    	Connection connection = new DBConnection().getConnection();
    	System.out.println("Connection to which Database: " + connection.getCatalog());
    /*	
       Customer customer = new Customer(1, "Sanru", "Email", "Westside", false, CustRole.ADMIN);
       
       System.out.println("Customer:" + customer);
       System.out.println(customer.getCustName());
       */
    }
}
