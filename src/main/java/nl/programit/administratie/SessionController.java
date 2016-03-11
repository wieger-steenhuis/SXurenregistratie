package nl.programit.administratie;

import java.time.*;
import java.util.*;

public class SessionController {

    ArrayList<Session> sessions = new ArrayList<>();
    DataPersister database = DataPersister.getInstance();

    public SessionController(){

        //Dummy Sessions
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

        Calendar training6 = new GregorianCalendar();
        training6.set(2016, Calendar.MARCH, 12, 9, 0, 0);
        Calendar training7 = new GregorianCalendar();
        training7.set(2016, Calendar.MARCH, 12, 10, 0, 0);
        Calendar training8 = new GregorianCalendar();
        training8.set(2016, Calendar.MARCH, 12, 11, 0, 0);
        Calendar training9 = new GregorianCalendar();
        training9.set(2016, Calendar.MARCH, 12, 12, 0, 30);
        Calendar training10 = new GregorianCalendar();
        training10.set(2016, Calendar.MARCH, 12, 14, 0, 0);
        Calendar training11 = new GregorianCalendar();
        training11.set(2016, Calendar.MARCH, 12, 15, 0, 0);
        Calendar training12 = new GregorianCalendar();
        training12.set(2016, Calendar.MARCH, 12, 16, 0,30);


        Person tessa = database.retrieveEntry("9999");
        Person judith = database.retrieveEntry("8888");
        Person baddi = database.retrieveEntry("1111");
        Person felix = database.retrieveEntry("2222");
        Person sjoerd = database.retrieveEntry("3333");
        Person ger = database.retrieveEntry("4444");
        Person aaron = database.retrieveEntry("5555");

        Session s1 = new Session();
        s1.setTrainer((Trainer)tessa);
        s1.setCustomer((nl.programit.administratie.Customer)baddi);
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

        Session s6 = new Session();
        s6.setTrainer((Trainer)tessa);
        s6.setCustomer((Customer)baddi);
        s6.setApproved(false);
        s6.setSessionDateAndTime(training6);

        Session s7 = new Session();
        s7.setTrainer((Trainer)tessa);
        s7.setCustomer((Customer)aaron);
        s7.setApproved(false);
        s7.setSessionDateAndTime(training7);

        Session s8 = new Session();
        s8.setTrainer((Trainer)tessa);
        s8.setCustomer((Customer)sjoerd);
        s8.setApproved(false);
        s8.setSessionDateAndTime(training8);

        Session s9 = new Session();
        s9.setTrainer((Trainer)tessa);
        s9.setCustomer((Customer)ger);
        s9.setApproved(false);
        s9.setSessionDateAndTime(training9);

        Session s10 = new Session();
        s10.setTrainer((Trainer)judith);
        s10.setCustomer((Customer)sjoerd);
        s10.setApproved(false);
        s10.setSessionDateAndTime(training10);

        Session s11 = new Session();
        s11.setTrainer((Trainer)judith);
        s11.setCustomer((Customer)ger);
        s11.setApproved(false);
        s11.setSessionDateAndTime(training11);


        createSession(s1);
        createSession(s2);
        createSession(s3);
        createSession(s4);
        createSession(s5);
        createSession(s6);
        createSession(s7);
        createSession(s8);
        createSession(s9);
        createSession(s10);
        createSession(s11);

    }

    public boolean createSession(Session session) {
        sessions.add(session);
        return true;
    }

    public ArrayList<Session> retrieveSessionListbyDate(LocalDate date) {

        ArrayList<Session> todaysSessions = new ArrayList<>();
        for (Session s : sessions){
            if (date.getYear()==s.getSessionDateAndTime().get(Calendar.YEAR) &&date.getMonthValue()-1==s.getSessionDateAndTime().get(Calendar.MONTH)&& date.getDayOfMonth()==s.getSessionDateAndTime().get(Calendar.DAY_OF_MONTH))
                todaysSessions.add(s);
            }

        return todaysSessions;
    }

    public boolean updateSession(Session session) {
        return false;
    }

    public boolean deleteSession(Session session) {
        return false;
    }

    public Session getSessionForApproval(int indexnr){
        return sessions.get(indexnr);
    }

    public boolean approveSession(Session session, String customerPin){
        if (session.getCustomer().getPin().equals(customerPin)){
            session.setApproved(true);
            session.setApprovedDateAndTime(Calendar.getInstance());//date = now
            return true;
        }
        else return false;
    }
}

