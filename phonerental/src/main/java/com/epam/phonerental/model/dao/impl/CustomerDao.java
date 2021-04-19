package com.epam.phonerental.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.phonerental.domain.CustRole;
import com.epam.phonerental.domain.Customer;
import com.epam.phonerental.model.config.DBConnection;
import com.epam.phonerental.model.dao.GenericDao;

public class CustomerDao implements GenericDao<Customer> {

	private static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer_table WHERE cust_id=?";

	private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer_table WHERE cust_id = ?";

	private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer_table";

	private Connection connection = new DBConnection().getConnection();

	private static final String INSERT_CUSTOMER = "INSERT INTO customer_table(cust_name, cust_email, cust_address, cust_blocked, cust_role)"
			+ "VALUES(?, ?, ?, ?, ?)";

	private static final String UPDATE_CUSTOMER = "UPDATE customer_table SET cust_name = ?, cust_email = ?, cust_address = ?, cust_blocked = ?, cust_role = ? WHERE cust_id = ?";

	@Override
	public int insertItem(final Customer item) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(INSERT_CUSTOMER);
			preparedstatement.setString(1, item.getCustName());
			preparedstatement.setString(2, item.getCustEmail());
			preparedstatement.setString(3, item.getCustAddress());
			preparedstatement.setBoolean(4, item.isCustBlocked());
			preparedstatement.setString(5, item.getCustRole().name());

			return preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Customer> getAllItems() {
		// Temporary Holder
		List<Customer> customers = new ArrayList<>();

		try {
			PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				Customer customer = getCustomer(resultSet);
				customers.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}



	@Override
	public Customer getItemById(long id) {
		PreparedStatement preparedstatement;
		Customer customer = new Customer(); 
		try {
			preparedstatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
			preparedstatement.setLong(1, id);
			
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				customer = getCustomer(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int updateItem(final Customer item) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(UPDATE_CUSTOMER);
			preparedstatement.setString(1, item.getCustName());
			preparedstatement.setString(2, item.getCustEmail());
			preparedstatement.setString(3, item.getCustAddress());
			preparedstatement.setBoolean(4, item.isCustBlocked());
			preparedstatement.setString(5, item.getCustRole().name());
			preparedstatement.setLong(6, item.getCustId());

			return preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteItem(long id) {
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
			preparedstatement.setLong(1, id);
			
			return preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	private Customer getCustomer(ResultSet resultSet) throws SQLException {
		long custId = resultSet.getLong("cust_id");
		String custName = resultSet.getString("cust_name");
		String custEmail = resultSet.getString("cust_email");
		String custAddress = resultSet.getString("cust_address");
		boolean custBlocked = resultSet.getBoolean("cust_blocked");
		CustRole custRole = CustRole.valueOf(resultSet.getString("cust_role"));

		return new Customer(custId, custName, custEmail, custAddress, custBlocked, custRole);
		
	}

}
