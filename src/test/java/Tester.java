import nl.Programit.administratie.*;

public class Tester {

    public static void main(String[] args) {
        //create persons (Customer, Trainer and Administrator):
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
        mark.setCity("Asten");

        //create 'Database' (txt file) and add (Administror/Trainer/Customer) persons:
        DataPersister dP = DataPersister.getInstance();

        dP.createEntry(baddi);
        dP.createEntry(wieger);
        dP.createEntry(mark);

        //retrieve and print entries by firstname or pin:
        dP.printEntry(dP.retrieveEntry("Wieger"));
        dP.printEntry(dP.retrieveEntry(1824));
        dP.printEntry(dP.retrieveEntry(5555));
        dP.printEntry(dP.retrieveEntry(8888));

        System.out.println("Mark woont in "+dP.retrieveEntry(1824).getCity());

        //print entire database:
        dP.printDatabase();
    }
}
