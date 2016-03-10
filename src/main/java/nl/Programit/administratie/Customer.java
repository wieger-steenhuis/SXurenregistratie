package nl.programit.administratie;

public class Customer extends Person {
	private String custumerID;
	private int credits;
	//private Subscription mySubscription; nog niet zeker of dat nodig is
	//private Gym mijnSportShool; nog niet zeker of dat nodig is

	public void increaseCredits(int amount){
		credits += amount;
	}
	public void decreaseCredits(){
		credits--;
	}

	public String getCustumerID() {
		return custumerID;
	}

	public void setCustumerID(String custumerID) {
		this.custumerID = custumerID;
	}

	/*public Subscription getMySubscription() {
		return mySubscription;
	}

	public void setMySubscription(Subscription mySubscription) {
		this.mySubscription = mySubscription;
	}*/

	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
}
