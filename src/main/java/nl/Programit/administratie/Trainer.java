package nl.programit.administratie;

public class Trainer extends Person {
	private String employeeId;
	private int approvedSessions;
	//private Gym myGym; nog niet zeker of dat nodig is
	private boolean active;

	public void incrementApprovedSessions(int i){
		approvedSessions += i;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getApprovedSessions() {
		return approvedSessions;
	}
	public void setApprovedSessions(int approvedSessions) {
		this.approvedSessions = approvedSessions;
	}
	/*public Gym getMyGym() {
		return myGym;
	}
	public void setMyGym(Gym myGym) {
		this.myGym = myGym;
	}*/
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
