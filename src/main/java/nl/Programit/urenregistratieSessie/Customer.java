package test;

public class Customer extends Person {
	
	private int id;
	private int credits;
	private String pinCode;
	//private Trainer defaultTrainer; DISCUSS
	
	Customer(int id, String name, String pinCode){
		this.id = id;
		this.pinCode = pinCode;
		this.name = name;
	}
	public void increaseCredits(int amount){
		credits += amount;
	}
	public void decreaseCredits(){
		credits--;
	}
	public boolean verifySession(String pinCode, Session session){
		if(this.pinCode == pinCode){
			decreaseCredits();
			session.getTrainer().increaseExecutedSessions(session);;
			return true;
		}else{
			return false;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
	
	

}
