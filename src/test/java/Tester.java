import nl.Programit.urenregistratieModel1.*;

/**
 * Created by ProgramIT on 2-3-2016.
 */
public class Tester {

    public static void main(String[] args) {
        Person baddi = new Administrator();
        baddi.setPin(8888);
        baddi.setFirstName("Baddi");


        Person wieger = new Trainer();
        wieger.setPin(5555);
        wieger.setFirstName("Wieger");


        Person mark = new Customer();
        mark.setPin(1824);
        mark.setFirstName("Mark");

        AdminOperator a = new AdminOperator();
        a.persons.add(baddi);
        a.persons.add(wieger);
        a.persons.add(mark);
        System.out.println(a.checkPin(1824));
        System.out.println(a.checkPin(8888));

    }
}
