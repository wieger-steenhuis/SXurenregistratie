package nl.Programit.urenregistratieModel1;

public class Customer extends Person {
	private int custumerID;
	private Subscription mySubscription;
	//private Gym mijnSportShool; nog niet zeker of dat nodig is

	public int getCustumerID() {
		return custumerID;
	}

	public void setCustumerID(int custumerID) {
		this.custumerID = custumerID;
	}

	public Subscription getMySubscription() {
		return mySubscription;
	}

	public void setMySubscription(Subscription mySubscription) {
		this.mySubscription = mySubscription;
	}




}
