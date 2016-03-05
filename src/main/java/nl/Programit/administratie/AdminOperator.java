package nl.Programit.administratie;

/**
 * Created by ProgramIT on 2-3-2016.
 *
 */
public class AdminOperator { 

    private Trainer trainer;
    private Customer customer;
    private Administrator administrator;
    private Subscription subscription;
    private Person person;

    //Singelton class to ensure single instance
    private static AdminOperator instance;
    synchronized public static AdminOperator getInstance(){
        if (instance == null) {
            instance = new AdminOperator();
        }
        return instance;
    }



    //getters and setters:
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public  Person checkPin(int pin) {

        return null;
    }
}
