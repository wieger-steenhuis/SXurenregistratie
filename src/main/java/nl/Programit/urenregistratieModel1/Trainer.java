package nl.Programit.urenregistratieModel1;

public class Trainer extends nl.Programit.urenregistratieModel1.Person {
	private int employeeId;
	private int approvedSessions;
	private Gym myGym;

	public void incrementApprovedSessions(int i){
		approvedSessions += i;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getApprovedSessions() {
		return approvedSessions;
	}

	public void setApprovedSessions(int approvedSessions) {
		this.approvedSessions = approvedSessions;
	}

	public Gym getMyGym() {
		return myGym;
	}

	public void setMyGym(Gym myGym) {
		this.myGym = myGym;
	}
}
