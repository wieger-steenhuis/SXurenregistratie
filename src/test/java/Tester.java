import nl.programit.administratie.SessionController;

import java.time.LocalDate;

public class Tester {
    public static void main(String[] args) {
        SessionController controller = new SessionController();
        LocalDate ld = LocalDate.of(2015, 3, 31);
        System.out.println(controller.retrieveSessionListbyDate(ld));
    }




    /*

        //create persons (Customer, Trainer and Administrator):
        Administrator baddi = new Administrator();
        baddi.setPin(8888);
        baddi.setFirstName("Baddi");
        baddi.setAdministratorID(1);
        baddi.setCity("Venlo");

        Trainer wieger = new Trainer();
        wieger.setPin(5555);
        wieger.setFirstName("Wieger");
        wieger.setEmployeeId(2);
        wieger.setBirthDay(java.time.LocalDate.of(1981, 3, 25));

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
        System.out.println("Baddi woont in "+dP.retrieveEntry("Baddi").getCity());

        System.out.println("Wiegers verjaardag is "+dP.retrieveEntry("Wieger").getBirthDay());

        dP.printDatabase();

        Administrator baddi2 = new Administrator();
        baddi2.setPin(8888);
        baddi2.setFirstName("Baddi2");
        baddi2.setAdministratorID(1);
        baddi2.setCity("Venlo");

        Customer mark2 = new Customer();
        mark2.setPin(1824);
        mark2.setFirstName("MAAAARK");


        //dP.updateEntry(baddi2, 1313);
        //dP.updateEntry(mark2, 1331);

        //dP.deleteEntry(mark);

        //print entire database:
        dP.printDatabase();

        System.out.println(dP.retrieveEntry(1234));
*/

}
