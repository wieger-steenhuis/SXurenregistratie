package nl.programit.sxurenadministratie.model;

public class Customer extends Person {

    private int custumerID;
    private int credits;
    //private Subscription mySubscription; nog niet zeker of dat nodig is
    //private Gym mijnSportShool; nog niet zeker of dat nodig is

    public int getCustumerID() {
        return custumerID;
    }
    public void setCustumerID(int custumerID) {
        this.custumerID = custumerID;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
}

/*

    public void increaseCredits(int amount){
        credits += amount;
    }
    public void decreaseCredits(){
        credits--;
    }

    public Subscription getMySubscription() {
    return mySubscription;
}

public void setMySubscription(Subscription mySubscription) {
    this.mySubscription = mySubscription;
}*/


