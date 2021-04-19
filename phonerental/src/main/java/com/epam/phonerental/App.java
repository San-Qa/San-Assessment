package com.epam.phonerental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.epam.phonerental.domain.CustRole;
import com.epam.phonerental.domain.Customer;
import com.epam.phonerental.model.config.DBConnection;
import com.epam.phonerental.model.dao.impl.CustomerDao;
import com.epam.phonerental.util.PropertiesReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(final String[] args ) throws SQLException {
    	
    	CustomerDao customerDao = new CustomerDao();
    	
    	System.out.println("===========================SELECT ALL ==========================");
    	
    	List<Customer> customers = customerDao.getAllItems();
    	customers.forEach(System.out::println);
    	
    	System.out.println("===========================SELECT BY ID ==========================");
 
    	Customer customer = customerDao.getItemById(15);
    	System.out.println("Customer by Id: " + customer);
    	
    	System.out.println("===========================DELETE ==========================");
    	
    	System.out.println("Deleted Status " + customerDao.deleteItem(28));
    	List<Customer> customersAfterDelete = customerDao.getAllItems();
    	customersAfterDelete.forEach(System.out::println);
    	
    	System.out.println("===========================UPDATE ==========================");
    	
    	Customer customerBeforeUpdate = customerDao.getItemById(29);
    	System.out.println("customerBeforeUpdate: " + customerBeforeUpdate);
    	Customer updateCustomer = new Customer(29, "custName", "hkjkjkjhkjhkjhkjhk", "custAddress", false, CustRole.ADMIN);
    	System.out.println("Updated Status " + customerDao.updateItem(updateCustomer));
    	Customer customerAfterUpdate = customerDao.getItemById(29);
    	System.out.println("customerAfterUpdate: " + customerAfterUpdate);
    	
    	System.out.println("===========================INSERT ==========================");
    	Customer newcustomer = new Customer("custName", "BrownMunde", "custAddress", false, CustRole.ADMIN);
    	System.out.println("Insert Status: " + customerDao.insertItem(newcustomer));
    	List<Customer> customerNew = customerDao.getAllItems();
    	customerNew.forEach(System.out::println);
    	
    	
    	// INSERT, DELETE, UPDATE
    	
    	//CREATE CONNECTION
    	
    	//STATEMENT PREPAREDSTATEMENT
    	
    	//RESULT SET
    	
    	
    /*
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
