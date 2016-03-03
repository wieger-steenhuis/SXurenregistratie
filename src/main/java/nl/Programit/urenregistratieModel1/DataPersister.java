package nl.Programit.urenregistratieModel1;

import java.io.*;
import java.util.ArrayList;

//CRUD Operations to persist data (uses database.txt for testing purposes)
public class DataPersister {

    File file;

    //Singelton class to ensure single instance
    private static DataPersister dPinstance;
    synchronized public static DataPersister getInstance(){
        if (dPinstance == null) {
            dPinstance = new DataPersister();
        }
        return dPinstance;
    }

    private DataPersister(){
        createDatabase();
    }

    private void createDatabase() {
        try {
            file = new File("database.txt");
            if (!(file.exists())) {
                file.createNewFile();
            }
        }
        catch (IOException e){}

    }

    public void createEntry(Person p){
        String input;
        try {
            if (p instanceof Trainer) {
                input = "$<<TRAINERID>>" + ((Trainer) p).getEmployeeId() + "<<naam>>" + ((Trainer) p).getFirstName() + "<<pin>>" + ((Trainer) p).getPin()+"#\n";
            } else if (p instanceof Customer) {
                input = "$<<CUSTID>>" + ((Customer) p).getCustumerID() + "<<naam>>" + ((Customer) p).getFirstName() + "<<pin>>"+ ((Customer) p).getPin()+"#\n";
            } else if (p instanceof Administrator) {
                input = "$<<ADMIND>>" + ((Administrator) p).getAdministratorID() + "<<naam>>" + ((Administrator) p).getFirstName() + "<<pin>>" + ((Administrator) p).getPin()+"#\n";
            } else return;

            FileOutputStream out = new FileOutputStream(file, true); //boolean to append test in file
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(input);
        }
        catch (IOException e){}
    }

    public Person retrieveEntry(Person p){
        Person retrieved;
        String output = new String();

        try{
            FileInputStream in = new FileInputStream(file);
            DataInputStream din = new DataInputStream(in);
            while (true) {
                output += din.readUTF();
            }
        }
        catch (IOException e) {}

        ArrayList<String> inputLines = new ArrayList<>();

        String tempOutput = output;

        while (tempOutput != null){
            if (tempOutput.lastIndexOf('#') != -1){
                inputLines.add(tempOutput.substring((tempOutput.lastIndexOf('$')),tempOutput.length()-1));
                tempOutput = tempOutput.substring(0,tempOutput.lastIndexOf('$'));
            }

            else tempOutput = null;
        }
        for (String inputLine : inputLines){
            //System.out.println(inputLine.substring(inputLine.lastIndexOf('>')+1, inputLine.lastIndexOf('>')+5));
            if (inputLine.charAt(3)=='C'){
                retrieved = new Customer();
                retrieved.setPin(Integer.parseInt(inputLine.substring(inputLine.lastIndexOf('>')+1, inputLine.lastIndexOf('>')+5)));
                ((Customer)retrieved).setCustumerID(Integer.parseInt(inputLine.substring(inputLine.indexOf('>')+2,inputLine.indexOf('>')+3)));
                //((Customer)retrieved).setFirstName(inputLine.substring(inputLine.indexOf('<'),(inputLine.substring(inputLine.indexOf('>')+2)).indexOf('<')));
                return retrieved;
            }
            if (inputLine.charAt(3)=='A'){
                retrieved = new Administrator();
                retrieved.setPin(Integer.parseInt(inputLine.substring(inputLine.lastIndexOf('>')+1, inputLine.lastIndexOf('>')+5)));
                ((Administrator)retrieved).setAdministratorID(Integer.parseInt(inputLine.substring(inputLine.indexOf('>')+2,inputLine.indexOf('>')+3)));
                retrieved.setFirstName("BBBBBB");
                return retrieved;
            }
            if (inputLine.charAt(3)=='T'){
                retrieved = new Trainer();
                retrieved.setPin(Integer.parseInt(inputLine.substring(inputLine.lastIndexOf('>')+1, inputLine.lastIndexOf('>')+5)));
                ((Trainer)retrieved).setEmployeeId(Integer.parseInt(inputLine.substring(inputLine.indexOf('>')+2,inputLine.indexOf('>')+3)));
                retrieved.setFirstName("CCCCCC");
                return retrieved;
            }
            else

                return null;

        }
        return null;
    }
}

