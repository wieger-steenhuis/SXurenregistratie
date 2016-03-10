package nl.programit.sxurenadministratie.controllers;

//import nl.programit.administratie.*;
import nl.programit.sxurenadministratie.model.*;

import java.time.*;
import java.util.*;

public class SessionController implements SessionControllerInterface{

    Session session;
    ArrayList<Session> sessions = new java.util.ArrayList<>();
    //DataPersister database = DataPersister.getInstance();



    public SessionController(){


        //nl.programit.administratie.Person tessa = database.retrieveEntry("4444");

        Session s1 = new Session();
        //s1.setTrainer((nl.programit.administratie.Trainer)tessa);
        Session s2 = new Session();
        Session s3 = new Session();
        Session s4 = new Session();
        Session s5 = new Session();
    }





    @Override
    public boolean createSession(Session session) {
        sessions.add(session);
        return true;
    }

    @Override
    public ArrayList<String> retrieveSessionListbyDate(LocalDate date) {
        ArrayList<String> sessionsByDate = new ArrayList<>();
        for (Session a : sessions){
            sessionsByDate.add(a.toString());
        }
        return sessionsByDate;
    }

    @Override
    public boolean updateSession(Session session) {
        return false;
    }

    @Override
    public boolean deleteSession(Session session) {
        return false;
    }

    @Override
    public boolean approveSession(nl.programit.sxurenadministratie.model.Session session) {
        return false;
    }
}

