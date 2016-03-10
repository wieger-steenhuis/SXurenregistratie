package nl.programit.administratie;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO

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

    // constructor creates databasefile (if none exists)
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
        catch (IOException e){
            System.out.println("caught");}
    }

    // synchronized entryNumber to prevent simultaneous creation of entrynumber:
    private synchronized int nextEntryNumber(){
        ArrayList<String> inputLines = databaseCopy();
        if (inputLines == null) {
            return 100001;
        }
        else {
        String lastEntry = inputLines.get(inputLines.size()-1);
        int lastEntryNumber = Integer.parseInt(inputLineToString(lastEntry, "<eNR>>", "<fNm>>"));
        return lastEntryNumber + 1;
        }
    }

    // synchronized entry creation to prevent simultaneous creation of entries:
    public synchronized void createEntry(Person p){
        String input;
        p.setEntryNumber(nextEntryNumber());
            if (p instanceof Trainer) {
                input = "<tID>>" + ((Trainer) p).getEmployeeId();
            } else if (p instanceof Customer) {
                input = "<cID>>" + ((Customer) p).getCustumerID();
            } else if (p instanceof Administrator) {
                input = "<aID>>" + ((Administrator) p).getAdministratorID();
            } else return;
        input = input.concat("<eNR>>"+ p.getEntryNumber()+"<fNm>>" +  p.getFirstName() +"<lNm>>"+p.getLastName()+"<gdr>>"+p.getGender()+"<str>>"+p.getStreet()+"<hNr>>"+p.getHouseNr()+"<zip>>"+p.getZipCode()+"<cty>>"+p.getCity()+ "<eml>>"+ p.getEmailAddress()+ "<bDy>>"+ p.getBirthDayString()+ "<pin>>" + p.getPin()+"#");

        try(FileWriter fW = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fW)){
            writer.write(input);
        }
        catch (IOException e){
            System.out.println("caught");
        }
    }

    // retrieve entry (overloaded with pin and firstname parameter)
    public Person retrieveEntry(int pin){

        ArrayList<String> inputLines = databaseCopy();

        if (inputLines == null)
            return null;

        for (String inputLine : inputLines){
            if (inputLine.charAt(1)=='c' && Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#"))==pin){
                return createCustomer(inputLine);
            }
            else if (inputLine.charAt(1)=='a' && Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#"))==pin){
                return createAdministrator(inputLine);
            }
            else if (inputLine.charAt(1)=='t'&& Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#"))==pin){
                return createTrainer(inputLine);
            }
        }
        return null;
    }

    public Person retrieveEntry(String firstName){
        ArrayList<String> inputLines = databaseCopy();

        if (inputLines == null)
            return null;

        for (String inputLine : inputLines){
            if (firstName.equals(inputLineToString(inputLine, "<fNm>>", "<lNm>>"))){
                if (inputLine.charAt(1)=='c'){
                    return createCustomer(inputLine);
                }
                else if (inputLine.charAt(1)=='a'){
                    return createAdministrator(inputLine);
                }
                else if (inputLine.charAt(1)=='t'){
                    return createTrainer(inputLine);
                }
            }
        }
        return null;
    }

    //Update entry copies entire database to String, replaces entry and copies String back to txt-file:
    public void updateEntry(Person p, int pinToCheck){
        ArrayList<String> inputLines = databaseCopy();
        String newDatabase = "";

        if (inputLines == null)
            return;

        for (int i = 0; i<inputLines.size(); i++) {
            if (Integer.parseInt(inputLineToString(inputLines.get(i), "<pin>>", "#")) == pinToCheck) {
                inputLines.set(i, createUpdatedEntryLine(p, inputLineToString(inputLines.get(i), "<eNR>>", "<fNm>>")));
                break;
            }
        }
        for (String inputLine : inputLines){
            newDatabase = newDatabase.concat(inputLine);
        }
        replaceDataBase(newDatabase);
    }

    //Delete entry copies entire database to String, removes entry and copies String back to txt-file:
    public void deleteEntry(Person p){
        ArrayList<String> inputLines = databaseCopy();
        String newDatabase = "";

        if (inputLines == null)
            return;

        for (int i = 0; i<inputLines.size(); i++) {
            if (Integer.parseInt(inputLineToString(inputLines.get(i), "<pin>>", "#")) == p.getPin()) {
                inputLines.set(i, "0");
                break;
            }
        }
        for (String inputLine : inputLines){
            if (!(inputLine.equals("0")))
            newDatabase = newDatabase.concat(inputLine);
        }
        replaceDataBase(newDatabase);
    }

    // replace entryline in entry String array before copying back to txt-file:
    private synchronized String createUpdatedEntryLine(Person p, String entryNumber) {

        String input;

        if (p instanceof Trainer) {
            input = "<tID>>" + ((Trainer) p).getEmployeeId();
        } else if (p instanceof Customer) {
            input = "<cID>>" + ((Customer) p).getCustumerID();
        } else if (p instanceof Administrator) {
            input = "<aID>>" + ((Administrator) p).getAdministratorID();
        } else return null;
        input = input.concat("<eNR>>" + entryNumber + "<fNm>>" + p.getFirstName() + "<lNm>>" + p.getLastName() + "<gdr>>" + p.getGender() + "<str>>" + p.getStreet() + "<hNr>>" + p.getHouseNr() + "<zip>>" + p.getZipCode() + "<cty>>" + p.getCity() + "<eml>>" + p.getEmailAddress() + "<bDy>>" + p.getBirthDayString() + "<pin>>" + p.getPin() + "#");
        return input;
    }

    // replaces whole database after entry update or delete:
    private void replaceDataBase(String database){
        try(FileWriter fW = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fW)){
            writer.write(database);
        }
        catch (IOException e){
            System.out.println("caught");
        }
    }

    // creation of persons
    private Customer createCustomer(String inputLine){
        Customer retrieved = new Customer();
        retrieved.setCustumerID(Integer.parseInt(inputLineToString(inputLine, "<cID>>", "<eNR>>")));
        retrieved.setFirstName(inputLineToString(inputLine, "<fNm>>", "<lNm>>"));
        retrieved.setLastName(inputLineToString(inputLine, "<lNm>>", "<gdr>>"));
        retrieved.setGender(inputLineToString(inputLine, "<gdr>>", "<str>>"));
        retrieved.setStreet(inputLineToString(inputLine, "<str>>", "<hNr>>"));
        retrieved.setHouseNr(Integer.parseInt(inputLineToString(inputLine, "<hNr>>", "<zip>>")));
        retrieved.setZipCode(inputLineToString(inputLine, "<zip>>", "<cty>>"));
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<eml>>"));
        retrieved.setEmailAddress(inputLineToString(inputLine, "<eml>>", "<bDy>>"));
        retrieved.setBirthdayStringInput(inputLineToString(inputLine, "<bDy>>", "<pin>>"));
        retrieved.setPin(Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#")));
        return retrieved;
    }
    private Administrator createAdministrator(String inputLine){
        Administrator retrieved = new Administrator();
        retrieved.setAdministratorID(Integer.parseInt(inputLineToString(inputLine, "<aID>>", "<eNR>>")));
        retrieved.setFirstName(inputLineToString(inputLine, "<fNm>>", "<lNm>>"));
        retrieved.setLastName(inputLineToString(inputLine, "<lNm>>", "<gdr>>"));
        retrieved.setGender(inputLineToString(inputLine, "<gdr>>", "<str>>"));
        retrieved.setStreet(inputLineToString(inputLine, "<str>>", "<hNr>>"));
        retrieved.setHouseNr(Integer.parseInt(inputLineToString(inputLine, "<hNr>>", "<zip>>")));
        retrieved.setZipCode(inputLineToString(inputLine, "<zip>>", "<cty>>"));
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<eml>>"));
        retrieved.setEmailAddress(inputLineToString(inputLine, "<eml>>", "<bDy>>"));
        retrieved.setBirthdayStringInput(inputLineToString(inputLine, "<bDy>>", "<pin>>"));
        retrieved.setPin(Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#")));
        return retrieved;
    }
    private Trainer createTrainer(String inputLine){
        Trainer retrieved = new Trainer();
        retrieved.setEmployeeId(Integer.parseInt(inputLineToString(inputLine, "<tID>>", "<eNR>>")));
        retrieved.setFirstName(inputLineToString(inputLine, "<fNm>>", "<lNm>>"));
        retrieved.setLastName(inputLineToString(inputLine, "<lNm>>", "<gdr>>"));
        retrieved.setGender(inputLineToString(inputLine, "<gdr>>", "<str>>"));
        retrieved.setStreet(inputLineToString(inputLine, "<str>>", "<hNr>>"));
        retrieved.setHouseNr(Integer.parseInt(inputLineToString(inputLine, "<hNr>>", "<zip>>")));
        retrieved.setZipCode(inputLineToString(inputLine, "<zip>>", "<cty>>"));
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<eml>>"));
        retrieved.setEmailAddress(inputLineToString(inputLine, "<eml>>", "<bDy>>"));
        retrieved.setBirthdayStringInput(inputLineToString(inputLine, "<bDy>>", "<pin>>"));
        retrieved.setPin(Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#")));
        return retrieved;
    }

    // copies all entries in txt-file to String array
    private ArrayList<String> databaseCopy(){
        String output = null;
        try(FileReader fR = new FileReader(file);
            BufferedReader reader = new BufferedReader(fR)){
            output = reader.readLine();
        }
        catch (IOException e){
            System.out.println("caught");
        }
        ArrayList<String> inputLines = new ArrayList<>();

        if (output != null) {
            while (output.indexOf('#') != -1) {
                inputLines.add(output.substring(0, output.indexOf('#') + 1));
                output = output.substring(output.indexOf('#') + 1, output.length());
            }
            return inputLines;
        }
        else return null;
    }

    // retrieve all items from database with regex matching:
    private String inputLineToString(String inputLine, String regex1, String regex2){
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

    //printing 1 entry:
    public void printEntry (Person p){
        if (p instanceof Administrator){
            System.out.println("Admin: "+((Administrator) p).getAdministratorID()+" naam: "+p.getFirstName()+" pin: "+p.getPin());
        }
        if (p instanceof Customer){
            System.out.println("Cust: "+((Customer) p).getCustumerID()+" naam: "+p.getFirstName()+" pin: "+p.getPin());
        }
        if (p instanceof Trainer){
            System.out.println("Trainer: "+((Trainer) p).getEmployeeId()+" naam: "+p.getFirstName()+" pin: "+p.getPin());
        }
    }

    //print entire database:
    public void printDatabase(){
        ArrayList<String> inputLines = databaseCopy();

        if (inputLines == null)
            return;

        for (String inputLine : inputLines){
            System.out.println(inputLine);
        }
    }
}

