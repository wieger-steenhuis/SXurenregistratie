package nl.Programit.urenregistratieModel1;

import java.util.ArrayList;

/**
 * Created by ProgramIT on 2-3-2016.
 *
 */
public class AdminOperator {

    private Trainer trainer;
    private Customer customer;
    private Administrator administrator;
    private Subscription subscription;

    public  ArrayList <Person> persons = new ArrayList<>();

    //Singelton class to ensure single instance
    private static AdminOperator instance;
    synchronized public static AdminOperator getInstance(){
        if (instance == null) {
            instance = new AdminOperator();
        }
        return instance;
    }

    private AdminOperator(){
        Administrator baddi = new Administrator();
        baddi.setPin(8888);
        baddi.setFirstName("Baddi");
        baddi.setAdministratorID(1);


        Trainer wieger = new Trainer();
        wieger.setPin(5555);
        wieger.setFirstName("Wieger");
        wieger.setEmployeeId(2);


        Customer mark = new Customer();
        mark.setPin(1824);
        mark.setFirstName("Mark");
        mark.setCustumerID(3);


        this.persons.add(baddi);
        this.persons.add(wieger);
        this.persons.add(mark);
    }


    public  Person checkPin(int pin){
        for (Person p : persons) {
            if (pin == p.getPin()) {
                if (p instanceof Trainer) setTrainer((Trainer) p);
                else if (p instanceof Administrator) setAdministrator((Administrator) p);
                else if (p instanceof Customer) setCustomer((Customer) p);
                return p;
            }
        }
        return null;
    }

    public Trainer searchTrainer (int employeeId){
        for(Person p: persons){
            if (p instanceof Trainer) {
                if (((Trainer) p).getEmployeeId() == employeeId)
                    return (Trainer) p;
            }
        }
        return null;
    }

    public Customer searchCustomer (int custumerID){
        for(Person p: persons) {
            if (p instanceof Customer) {
                if (((Customer) p).getCustumerID() == custumerID)
                    return (Customer) p;
            }
        }
        return null;
    }

    public Administrator searchAdministrator (int administratorID){
        for(Person p: persons) {
            if (p instanceof Administrator) {
                if (((Administrator) p).getAdministratorID() == administratorID)
                    return (Administrator) p;
            }
        }
        return null;
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

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }


    /*public Subscription searchSubscription (int subscriptionID){
        for(Subscription a: subscriptions){
            if (a.getSubscriptionID() == subscriptionID)
                return a;
        }
        return null;
    }

    public void sessieAfvinken (SportSessie s){
        (searchKlant(s.getKlant()).getMySubscription()).decreaseSessionsCredit(VINK); // ga ervan uit dat er nog sessies over zijn
        (searchTrainer(s.getTrainer())).incrementApprovedSessions(VINK);
        s.setBevestigd(true);
    };

    private java.util.ArrayList <SportSessie> sessies =new ArrayList<>();
    public SportSessie searchSessie (int trainer, int klant){
        for( SportSessie s: sessies){
            if (s.trainer == trainer && s.klant == klant )
                return s;
        }
        return null;
    }

    */

}
