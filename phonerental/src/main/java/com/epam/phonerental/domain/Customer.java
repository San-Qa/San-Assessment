package com.epam.phonerental.domain;

public class Customer {

	// Variables
	private long custId;
	private String custName;
	private String custEmail;
	private String custAddress;
	private boolean custBlocked;
	private CustRole custRole;

	// Constructors
	public Customer() {
		super();
	}

	public Customer(String custName, String custEmail, String custAddress, boolean custBlocked, CustRole custRole) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custBlocked = custBlocked;
		this.custRole = custRole;
	}

	public Customer(long custId, String custName, String custEmail, String custAddress, boolean custBlocked,
			CustRole custRole) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custBlocked = custBlocked;
		this.custRole = custRole;
	}

	// Getter and Setter
	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public boolean isCustBlocked() {
		return custBlocked;
	}

	public void setCustBlocked(boolean custBlocked) {
		this.custBlocked = custBlocked;
	}

	public CustRole getCustRole() {
		return custRole;
	}

	public void setCustRole(CustRole custRole) {
		this.custRole = custRole;
	}

	// too string
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custAddress="
				+ custAddress + ", custBlocked=" + custBlocked + ", custRole=" + custRole + "]";
	}

	// hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custAddress == null) ? 0 : custAddress.hashCode());
		result = prime * result + (custBlocked ? 1231 : 1237);
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + (int) (custId ^ (custId >>> 32));
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custRole == null) ? 0 : custRole.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custAddress == null) {
			if (other.custAddress != null)
				return false;
		} else if (!custAddress.equals(other.custAddress))
			return false;
		if (custBlocked != other.custBlocked)
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custRole != other.custRole)
			return false;
		return true;
	}

}
