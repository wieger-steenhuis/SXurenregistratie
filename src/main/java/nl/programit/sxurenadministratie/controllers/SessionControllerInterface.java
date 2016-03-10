package nl.programit.sxurenadministratie.controllers;

import nl.programit.sxurenadministratie.model.*;

import java.time.*;
import java.util.ArrayList;

public interface SessionControllerInterface {

    public boolean createSession(Session session);
    public ArrayList<String> retrieveSessionListbyDate(LocalDate date);
    public boolean updateSession(Session session);
    public boolean deleteSession(Session session);
}
