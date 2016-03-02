package nl.Programit.urenregistratieModel1;
public abstract class Person {
	private String firstName;
	private String lastName;
	private String street;
	private String zipCode;
	private String city;
	private int houseNr;
	private java.util.Date birthDay;
	private String bankAccountID;
	private int pin;

	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHouseNr() {
		return houseNr;
	}
	public void setHouseNr(int houseNr) {
		this.houseNr = houseNr;
	}



	public java.util.Date getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(java.util.Date birthDay) {
		this.birthDay = birthDay;
	}



	public String getBankAccountID() {
		return bankAccountID;
	}



	public void setBankAccountID(String bankAccountID) {
		this.bankAccountID = bankAccountID;
	}




}