package com.epam.phonerental.domain;

public class Phone {

	// Variables
	private long phoneId;
	private String phoneModel;
	private String phoneReleaseYear;
	private String phoneColour;
	private String phoneCompany;

	// C
	public Phone() {
		super();
	}

	public Phone(String phoneModel, String phoneReleaseYear, String phoneColour, String phoneCompany) {
		super();
		this.phoneModel = phoneModel;
		this.phoneReleaseYear = phoneReleaseYear;
		this.phoneColour = phoneColour;
		this.phoneCompany = phoneCompany;
	}

	public Phone(long phoneId, String phoneModel, String phoneReleaseYear, String phoneColour, String phoneCompany) {
		super();
		this.phoneId = phoneId;
		this.phoneModel = phoneModel;
		this.phoneReleaseYear = phoneReleaseYear;
		this.phoneColour = phoneColour;
		this.phoneCompany = phoneCompany;
	}

	// Getter and Setter

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getPhoneReleaseYear() {
		return phoneReleaseYear;
	}

	public void setPhoneReleaseYear(String phoneReleaseYear) {
		this.phoneReleaseYear = phoneReleaseYear;
	}

	public String getPhoneColour() {
		return phoneColour;
	}

	public void setPhoneColour(String phoneColour) {
		this.phoneColour = phoneColour;
	}

	public String getPhoneCompany() {
		return phoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	// ToString
	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneModel=" + phoneModel + ", phoneReleaseYear=" + phoneReleaseYear
				+ ", phoneColour=" + phoneColour + ", phoneCompany=" + phoneCompany + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneColour == null) ? 0 : phoneColour.hashCode());
		result = prime * result + ((phoneCompany == null) ? 0 : phoneCompany.hashCode());
		result = prime * result + (int) (phoneId ^ (phoneId >>> 32));
		result = prime * result + ((phoneModel == null) ? 0 : phoneModel.hashCode());
		result = prime * result + ((phoneReleaseYear == null) ? 0 : phoneReleaseYear.hashCode());
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
		Phone other = (Phone) obj;
		if (phoneColour == null) {
			if (other.phoneColour != null)
				return false;
		} else if (!phoneColour.equals(other.phoneColour))
			return false;
		if (phoneCompany == null) {
			if (other.phoneCompany != null)
				return false;
		} else if (!phoneCompany.equals(other.phoneCompany))
			return false;
		if (phoneId != other.phoneId)
			return false;
		if (phoneModel == null) {
			if (other.phoneModel != null)
				return false;
		} else if (!phoneModel.equals(other.phoneModel))
			return false;
		if (phoneReleaseYear == null) {
			if (other.phoneReleaseYear != null)
				return false;
		} else if (!phoneReleaseYear.equals(other.phoneReleaseYear))
			return false;
		return true;
	}

}
