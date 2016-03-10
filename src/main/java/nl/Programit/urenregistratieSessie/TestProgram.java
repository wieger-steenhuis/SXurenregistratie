package nl.programit.urenregistratiesessie;

import java.text.*;
import java.util.*;

public class TestProgram {

	boolean inputBoolean = true;
	int creditsCustomer =10;
	int creditsTrainer = 0;
	 
	
	public static void main(String[] args){
		TestProgram jojo = new TestProgram();
		while(jojo.inputBoolean){
			jojo.approveSession();
		}
	}
	public void approveSession(){

		System.out.println("Naam van de klant:  of typ qqq om te stoppen");
		Scanner scan = new Scanner(System.in);
		String nameClient = scan.next();
		if(nameClient.equals("qqq")){
			System.out.println("Aborted");
			inputBoolean = false;
			return;
		}
		System.out.println("Naam van de trainer");
		String nameTrainer = scan.next();
		System.out.println("Pin code klant ");
		String pinCustomer = scan.next();//nog geen controle op juistheid
		
		System.out.println("Geef de datum \"11-June-07\"");
		String invoerDate = scan.next();
		System.out.println("U heeft deze datum ingegeven"+ invoerDate);
		DateFormat formatter ; 
		Date dateTraining ; 
		formatter = new SimpleDateFormat("dd-MMM-yy");
		try {
		dateTraining = formatter.parse(invoerDate);
		}
		catch(ParseException e){
			System.out.println("ParseException"+e); //debug
			dateTraining = null;
		}
		// Date dateTraining = new Date(2016,01,12); //vaste datum Hoe invoeren in scanner??

		//TODO opnieuw definieren met andere customer / person / administrator / trainer classes
		/*
		Customer customer = new Customer(1, nameClient, "3234");
		customer.setCredits(creditsCustomer); // Klant heeft nu 10 credits!!

		Trainer trainer = new Trainer(1,nameTrainer, "1234");
		trainer.setExecutedSessions(creditsTrainer++); // Trainer heeft nu 0 credits !!

		Session session = new Session(trainer, customer, dateTraining); //Nieuwe sessie gaat starten

		customer.verifySession(customer.getPinCode(),session);

		ArrayList<Session> sessielist = new ArrayList<>();
		sessielist.add(session);
		for (Session d:sessielist) {

			System.out.println(d.getTrainer().getName() + " traint " + d.getCustomer().getName() + " op " + d.getDate());
			System.out.println("Klant " + customer.getName() + " heeft nu " + customer.getCredits() +
					" Credits." + " Trainer " + trainer.getName() + " heeft nu " + trainer.getExecutedSessions() + " credits");

		}*/

	}
}

