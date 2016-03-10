package nl.programit.sxurenadministratie.model;

public class Trainer extends Person {
    private int employeeId;
    private int approvedSessions;
    //private Gym myGym; nog niet zeker of dat nodig is
    private boolean active;

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getApprovedSessions() {
        return approvedSessions;
    }
    public void setApprovedSessions(int approvedSessions) {
        this.approvedSessions = approvedSessions;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}

    /*public Gym getMyGym() {
        return myGym;
    }
    public void setMyGym(Gym myGym) {
        this.myGym = myGym;
    }*/
