package nl.Programit.urenregistratieModel1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                input = "$tID>>" + ((Trainer) p).getEmployeeId() + "nam>>" +  p.getFirstName() + "pin>>" + p.getPin()+"#\n";
            } else if (p instanceof Customer) {
                input = "$cID>>" + ((Customer) p).getCustumerID() + "nam>>" + p.getFirstName() + "pin>>"+ p.getPin()+"#\n";
            } else if (p instanceof Administrator) {
                input = "$aID>>" + ((Administrator) p).getAdministratorID() + "nam>>" + p.getFirstName() + "pin>>" +  p.getPin()+"#\n";
            } else return;

            FileOutputStream out = new FileOutputStream(file, true); //boolean to append test in file
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(input);
        }
        catch (IOException e){}
    }

    public Person retrieveEntry(int pin){
        //Person retrieved;
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
            if (inputLine.charAt(1)=='c' && Integer.parseInt(databaseToString(inputLine, "pin>>", "#"))==pin){
                Customer retrieved = new Customer();
                retrieved.setCustumerID(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
            else if (inputLine.charAt(1)=='a' && Integer.parseInt(databaseToString(inputLine, "pin>>", "#"))==pin){
                Administrator retrieved = new Administrator();
                retrieved.setAdministratorID(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
            else if (inputLine.charAt(1)=='t'&& Integer.parseInt(databaseToString(inputLine, "pin>>", "#"))==pin){
                Trainer retrieved = new Trainer();
                retrieved.setEmployeeId(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
        }
        return null;
    }

    public Person retrieveEntry(Person p){
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
            if (inputLine.charAt(1)=='c'){
                Customer retrieved = new Customer();
                retrieved.setCustumerID(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
            else if (inputLine.charAt(1)=='a'){
                Administrator retrieved = new Administrator();
                retrieved.setAdministratorID(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
            else if (inputLine.charAt(1)=='t'){
                Trainer retrieved = new Trainer();
                retrieved.setEmployeeId(Integer.parseInt(databaseToString(inputLine, "ID>>", "nam>>")));
                retrieved.setFirstName(databaseToString(inputLine, "nam>>", "pin>>"));
                retrieved.setPin(Integer.parseInt(databaseToString(inputLine, "pin>>", "#")));
                return retrieved;
            }
        }
        return null;
    }

    public String databaseToString (String inputLine, String regex1, String regex2){
        int start;
        int end;
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher =pattern.matcher(inputLine);
        if (matcher.find()) {
            start = matcher.end();
        }
        else return null;
        pattern  = Pattern.compile(regex2);
        matcher =pattern.matcher(inputLine);
        if (matcher.find()) {
            end = matcher.start();
        }
        else return null;
        return inputLine.substring(start, end);
    }

}

