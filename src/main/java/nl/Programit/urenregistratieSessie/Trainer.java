package test;

public class Trainer extends Person {
	private SessionManageable myGym;
	private int trainerId;
	private boolean active;
	private int executedSessions;
	private String pinCode;
	
	public Trainer (int id, String name, String pinCode){
		this.trainerId=id;
		this.name = name;
		this.pinCode = pinCode;
	}
	
	public void increaseExecutedSessions (Session session){
		this.executedSessions++;
		session.verify();
	}
	public boolean login(String pinCode){
		if(this.pinCode.equals(pinCode)){
			return true;
		}else{
			return false;
		}
	}

// DISCUSS	
//	public Session chooseSession(Session session){
//		return session;
//	}
	
	
	public int getId() {
		return trainerId;
	}
	public void setId(int trainerId) {
		this.trainerId = trainerId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getExecutedSessions() {
		return executedSessions;
	}
	public void setExecutedSessions(int executedSessions) {
		this.executedSessions = executedSessions;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	

}
