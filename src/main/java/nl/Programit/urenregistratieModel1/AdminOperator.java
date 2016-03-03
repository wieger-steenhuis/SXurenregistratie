package nl.Programit.urenregistratieModel1;

import java.util.ArrayList;

/**
 * Created by ProgramIT on 2-3-2016.
 */
public class AdminOperator {

    private Trainer trainer;
    private Customer customer;
    private nl.Programit.urenregistratieModel1.Administrator administrator;
    private Subscription subscription;


    private ArrayList <Customer> customers =new ArrayList<>();
    private ArrayList <Trainer> trainers =new ArrayList<>();
    private ArrayList <Subscription> subscriptions =new ArrayList<>();
    public  ArrayList <Person> persons = new ArrayList<>();


    public  Person checkPin(int pin){
        for (Person p : persons) {
            if (pin == p.getPin()) {
                if (p instanceof Trainer) this.trainer = (Trainer) p;
                else if (p instanceof Administrator) this.administrator = (Administrator) p;
                else if (p instanceof Customer) this.customer = (Customer) p;
                return p;
            }
        }
        return null;
    }


    public Trainer searchTrainer (int employeeId){
        for(Trainer t: trainers){
            if (t.getEmployeeId() == employeeId)
                return t;
        }
        return null;
    }

    public Customer searchCustomer (int custumerID){
        for(Customer c: customers){
            if (c.getCustumerID() == custumerID)
                return c;
        }
        return null;
    }


    public Subscription searchSubscription (int subscriptionID){
        for(Subscription a: subscriptions){
            if (a.getSubscriptionID() == subscriptionID)
                return a;
        }
        return null;
    }


    /*public void sessieAfvinken (SportSessie s){
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
