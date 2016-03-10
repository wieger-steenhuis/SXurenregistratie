package nl.programit.administratie;

/**
 Trainer (selectie op identificatiecode), Customer (selectie op
 identificatiecode), Date, Confirmed-Status (initieel false),
 zodat de sessie (op een later tijdstip) kan worden getoond (met
 namen, datum en status), geselecteerd en geaccordeerd.
 */

public class Session {
    private Trainer trainer;
    private Customer customer;
    private java.util.Calendar DateAndTime;
    private boolean approved;
    private double duration;

    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public java.util.Calendar getDateAndTime() {
        return DateAndTime;
    }
    public void setDateAndTime(java.util.Calendar dateAndTime) {
        DateAndTime = dateAndTime;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return customer.getFirstName()+" "+customer.getLastName()+" "+getDateAndTime().getTime().toString()+" "+isApproved();
    }
}
