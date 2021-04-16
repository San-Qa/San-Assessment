package com.epam.phonerental.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {

	//Variables
	private long orderId;
	private long custId;
	private long phoneId;
	private Date orderDate;
	private Date returnDate;
	private boolean phoneReturned;
	private double rentalcost;

	//Constructors
	public Order() {
		super();
	}

	public Order(long custId, long phoneId, Date orderDate, Date returnDate, boolean phoneReturned,
			double rentalcost) {
		super();
		this.custId = custId;
		this.phoneId = phoneId;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.phoneReturned = phoneReturned;
		this.rentalcost = rentalcost;
	}

	public Order(long orderId, long custId, long phoneId, Date orderDate, Date returnDate, boolean phoneReturned,
			double rentalcost) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.phoneId = phoneId;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.phoneReturned = phoneReturned;
		this.rentalcost = rentalcost;
	}

	//Getter and Setter

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isPhoneReturned() {
		return phoneReturned;
	}

	public void setPhoneReturned(boolean phoneReturned) {
		this.phoneReturned = phoneReturned;
	}

	public double getRentalcost() {
		return rentalcost;
	}

	public void setRentalcost(double rentalcost) {
		this.rentalcost = rentalcost;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custId=" + custId + ", phoneId=" + phoneId + ", orderDate=" + orderDate
				+ ", returnDate=" + returnDate + ", phoneReturned=" + phoneReturned + ", rentalcost=" + rentalcost
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (custId ^ (custId >>> 32));
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + (int) (phoneId ^ (phoneId >>> 32));
		result = prime * result + (phoneReturned ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(rentalcost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (custId != other.custId)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (phoneId != other.phoneId)
			return false;
		if (phoneReturned != other.phoneReturned)
			return false;
		if (Double.doubleToLongBits(rentalcost) != Double.doubleToLongBits(other.rentalcost))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

	
}
