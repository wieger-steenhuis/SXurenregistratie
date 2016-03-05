import nl.Programit.administratie.*;

public class Tester {

    public static void main(String[] args) {
        //create persons (Customer, Trainer and Administrator) with Singelton instance and constructor of AdminOperator class:
        //AdminOperator instance = AdminOperator.getInstance();

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

        //create 'Database' (txt file) and add (Administror/Trainer/Customer) persons:
        DataPersister dP = DataPersister.getInstance();

        dP.createEntry(baddi);
        dP.createEntry(wieger);
        dP.createEntry(mark);

        dP.printEntry(dP.retrieveEntry("Mark"));
        dP.printEntry(dP.retrieveEntry(1824));
        dP.printEntry(dP.retrieveEntry(5555));
        dP.printEntry(dP.retrieveEntry(8888));

        dP.printDatabase();

        //check pin and load (Administror/Trainer/Customer) person to adminOperator Instance
        //instance.checkPin(1824);
        //instance.setCustomer((Customer)dPinstance.retrieveEntry(1824));
        //System.out.println(instance.getCustomer().getFirstName());
        //System.out.println("ID: "+instance.getCustomer().getCustumerID()+" Naam: "+instance.getCustomer().getFirstName());

        //instance.checkPin(8888);
        //System.out.println("ID: "+instance.getAdministrator().getAdministratorID()+" Naam: "+instance.getAdministrator().getFirstName());

        //instance.checkPin(5555);
        //System.out.println("ID: "+instance.getTrainer().getEmployeeId()+" Naam: "+instance.getTrainer().getFirstName());


        //create entries:
        //dPinstance.createEntry(instance.getTrainer());
        //dPinstance.createEntry(instance.getAdministrator());
        //dPinstance.createEntry(instance.getCustomer());

        //retrieve entries:
        //System.out.println(dPinstance.retrieveEntry(instance.getCustomer()).getPin());
        //System.out.println(dPinstance.retrieveEntry(instance.getCustomer()).getFirstName());

        //System.out.println(dPinstance.retrieveEntry(instance.getAdministrator()).getPin());
        //System.out.println(dPinstance.retrieveEntry(instance.getAdministrator()).getFirstName());
        //instance.printEntry((nl.Programit.administratie.AdminOperator.getInstance().checkPin(1824)));
        //System.out.println((dPinstance.retrieveEntry(instance.getAdministrator())).getPin());

    }
}
