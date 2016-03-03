import nl.Programit.urenregistratieModel1.*;

/**
 * Created by ProgramIT on 2-3-2016.
 */
public class Tester {

    public static void main(String[] args) {
        //create persons (Customer, Trainer and Administrator):
        AdminOperator instance = AdminOperator.getInstance();

        instance.checkPin(1824);
        System.out.println("ID: "+instance.getCustomer().getCustumerID()+" Naam: "+instance.getCustomer().getFirstName());

        instance.checkPin(8888);
        System.out.println("ID: "+instance.getAdministrator().getAdministratorID()+" Naam: "+instance.getAdministrator().getFirstName());

        instance.checkPin(5555);
        System.out.println("ID: "+instance.getTrainer().getEmployeeId()+" Naam: "+instance.getTrainer().getFirstName());

        //create 'Database' (txt file):
        DataPersister dPinstance = DataPersister.getInstance();

        //create etries:
        dPinstance.createEntry(instance.getTrainer());
        dPinstance.createEntry(instance.getAdministrator());
        dPinstance.createEntry(instance.getCustomer());

        //retrieve entries:
        System.out.println((dPinstance.retrieveEntry(instance.getCustomer())).getPin());
        System.out.println(((Customer)dPinstance.retrieveEntry(instance.getCustomer())).getCustumerID());
        System.out.println((dPinstance.retrieveEntry(instance.getAdministrator())).getPin());

    }
}
