package nl.programit.administratie;

import java.time.*;
import java.util.*;

public class SessionController {

    Session session;
    ArrayList<Session> sessions = new java.util.ArrayList<>();
    DataPersister database = DataPersister.getInstance();



    public SessionController(){

        Calendar training1 = new GregorianCalendar();
        training1.set(2016, Calendar.MARCH, 11, 14, 0, 0);
        Calendar training2 = new GregorianCalendar();
        training2.set(2016, Calendar.MARCH, 11, 15, 0, 0);
        Calendar training3 = new GregorianCalendar();
        training3.set(2016, Calendar.MARCH, 11, 16, 0, 0);
        Calendar training4 = new GregorianCalendar();
        training4.set(2016, Calendar.MARCH, 11, 17, 0, 0);
        Calendar training5 = new GregorianCalendar();
        training5.set(2016, Calendar.MARCH, 11, 18, 0, 0);


        Person tessa = database.retrieveEntry("9999");
        Person baddi = database.retrieveEntry("1111");
        Person felix = database.retrieveEntry("2222");
        Person sjoerd = database.retrieveEntry("3333");
        Person ger = database.retrieveEntry("4444");
        Person aaron = database.retrieveEntry("5555");

        Session s1 = new Session();
        s1.setTrainer((Trainer)tessa);
        s1.setCustomer((Customer)baddi);
        s1.setApproved(true);
        s1.setSessionDateAndTime(training1);

        Session s2 = new Session();
        s2.setTrainer((Trainer)tessa);
        s2.setCustomer((Customer)felix);
        s2.setApproved(false);
        s2.setSessionDateAndTime(training2);

        Session s3 = new Session();
        s3.setTrainer((Trainer)tessa);
        s3.setCustomer((Customer)sjoerd);
        s3.setApproved(false);
        s3.setSessionDateAndTime(training3);

        Session s4 = new Session();
        s4.setTrainer((Trainer)tessa);
        s4.setCustomer((Customer)ger);
        s4.setApproved(false);
        s4.setSessionDateAndTime(training4);

        Session s5 = new Session();
        s5.setTrainer((Trainer)tessa);
        s5.setCustomer((Customer)aaron);
        s5.setApproved(false);
        s5.setSessionDateAndTime(training5);

        createSession(s1);
        createSession(s2);
        createSession(s3);
        createSession(s4);
        createSession(s5);
    }



    public boolean createSession(Session session) {
        sessions.add(session);
        return true;
    }

    public ArrayList<Session> retrieveSessionListbyDate(LocalDate date) {
        return sessions;
    }

    public boolean updateSession(Session session) {
        return false;
    }

    public boolean deleteSession(Session session) {
        return false;
    }

    public boolean approveSession(Session session){

        return true;
    }


}

