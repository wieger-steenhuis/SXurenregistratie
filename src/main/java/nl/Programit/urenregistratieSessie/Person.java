package test;

import java.text.DateFormat;

public class Person {
	protected String name;
	private String emailAddress;
	private String addressStreet;
	private String addressStreetNumber;
	private String addressZipCode;
	private String addressCity;
	private DateFormat birthDate;
	private String gender;
	private DateFormat startDate;
	private boolean active;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressStreetNumber() {
		return addressStreetNumber;
	}
	public void setAddressStreetNumber(String addressStreetNumber) {
		this.addressStreetNumber = addressStreetNumber;
	}
	public String getAddressZipCode() {
		return addressZipCode;
	}
	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public DateFormat getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(DateFormat birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public DateFormat getStartDate() {
		return startDate;
	}
	public void setStartDate(DateFormat startDate) {
		this.startDate = startDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
