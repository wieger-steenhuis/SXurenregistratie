package nl.Programit.administratie;

public class Subscription {
	private static final int START_1 = 12; // aantal sessies bij abonnement type 1
	private static final int TYPE_1 = 1;
	private final int subscriptionID;
	private final int custumerID;
	private int employeeId;
	private int sessionsCredit;
	private int sessionType; // bepaalt aantal sessies per week, voorlopig fixed 1

//Begindatum
	//Sessies over totaal

	//Constructor
	public Subscription(int custumerID, int subscriptionID){
		this.subscriptionID = subscriptionID;
		this.custumerID = custumerID;
		this.sessionsCredit = START_1; // voorlopig maar 1 type
		this.sessionType = TYPE_1;
	}

	public void decreaseSessionsCredit(int sessie) { // normaal 1
		sessionsCredit -= sessie;
	}

	// getters and setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSessionType() {
		return sessionType;
	}

	public void setSessionType(int sessionType) {
		this.sessionType = sessionType;
	}

	public int getSessionsCredit() {
		return sessionsCredit;
	}

	public void setSessionsCredit(int sessionsCredit) {
		this.sessionsCredit = sessionsCredit;
	}

	public int getCustumerID() {
		return custumerID;
	}

	public int getSubscriptionID() {
		return subscriptionID;
	}

}
