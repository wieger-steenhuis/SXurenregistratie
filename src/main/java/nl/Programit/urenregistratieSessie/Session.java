package nl.programit.urenregistratieSessie;

import nl.programit.administratie.*;
import java.util.Date;

public class Session {
	private int sessionId;
	private static int sessionsAmount =0;
	private Trainer trainer;
	private Customer customer;
	private boolean confirmed = false;
	private Date date;
	
	public Session(Trainer trainer, Customer customer, Date date){
		this.date = date;
		this.trainer = trainer;
		this.customer = customer;
		sessionsAmount++;
		this.sessionId = sessionsAmount;
	}

	//TODO deze method stond voorheen in customer... herschrijven naar session
	/*public boolean verifySession(String pinCode, Session session){
		if(this.pinCode == pinCode){
			decreaseCredits();
			session.getTrainer().increaseExecutedSessions(session);;
			return true;
		}else{
			return false;
		}
	}*/

	
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", trainer=" + trainer + ", customer=" + customer + ", confirmed="
				+ confirmed + ", date=" + date + "]";
	}

	public void verify(){
		this.confirmed = true;
	}
	
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
	public boolean isCorfirmed() {
		return confirmed;
	}
	public void setCorfirmed(boolean corfirmed) {
		this.confirmed = corfirmed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
	
}
