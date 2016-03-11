package nl.programit.administratie;

import java.util.Calendar;

/**
 Trainer (selectie op identificatiecode), Customer (selectie op
 identificatiecode), Date, Confirmed-Status (initieel false),
 zodat de sessie (op een later tijdstip) kan worden getoond (met
 namen, datum en status), geselecteerd en geaccordeerd.
 */

public class Session {
    private Trainer trainer;
    private Customer customer;
    private Calendar sessionDateAndTime;
    private boolean approved;
    private double duration;
    private Calendar approvedDateAndTime;

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
    public Calendar getSessionDateAndTime() {
        return sessionDateAndTime;
    }
    public void setSessionDateAndTime(Calendar sessionDateAndTime) {
        this.sessionDateAndTime = sessionDateAndTime;
    }
    public Calendar getApprovedDateAndTime() {
        return approvedDateAndTime;
    }
    public void setApprovedDateAndTime(Calendar approvedDateAndTime) {
        this.approvedDateAndTime = approvedDateAndTime;
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
        String approval = "";
        if (isApproved()) approval = "\u2713 ";
        return approval+" "+getSessionDateAndTime().get(Calendar.HOUR_OF_DAY)+":"+getSessionDateAndTime().get(Calendar.MINUTE)+"0 uur "+customer.getFirstName()+" "+customer.getLastName();
    }
}
