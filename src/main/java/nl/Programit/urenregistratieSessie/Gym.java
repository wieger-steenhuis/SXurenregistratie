
package test;
import java.util.Date;
import java.util.List;

public class Gym implements SessionManageable {
	private String name;
	private String email;
	
	List<Trainer> trainers;
	List<Customer> customers;
	List<Session> sessions;
	
	@Override
	public boolean VerifySession() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Session createSession(){
		return null;
	}
	
	@Override
	public void showSession(Trainer t, Date... d) {
		// TODO Auto-generated method stub
	}

	@Override
	public Session selectSession(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void createTrainer(){
		
	}
	public void createCustomer(){
		
	}
	
	public void showTrainers(){
		
	}
	public void showCustomers(){
		
	}
	
	public void sendMail(String email){
		
	}

	@Override
	public Trainer selectTrainer(int trainerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
