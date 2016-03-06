package nl.Programit.administratie;

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
        catch (IOException e){
            System.out.println("caught");}
    }

    public synchronized int nextEntryNumber(){
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
        input = input.concat("<eNR>>"+ p.getEntryNumber()+"<fNm>>" +  p.getFirstName() +"<lNm>>"+p.getLastName()+"<gdr>>"+p.getGender()+"<str>>"+p.getStreet()+"<hNr>>"+p.getHouseNr()+"<zip>>"+p.getZipCode()+"<cty>>"+p.getCity()+ "<pin>>" + p.getPin()+"#");

        try(FileWriter fW = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fW)){
            writer.write(input);
        }
        catch (IOException e){
            System.out.println("caught");
        }
    }

    public Person retrieveEntry(int pin){

        ArrayList<String> inputLines = databaseCopy();

        if (inputLines == null)
            return null;

        for (String inputLine : inputLines){
            //System.out.println(inputLine.substring(inputLine.lastIndexOf('>')+1, inputLine.lastIndexOf('>')+5));
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

    private Customer createCustomer(String inputLine){
        Customer retrieved = new Customer();
        retrieved.setCustumerID(Integer.parseInt(inputLineToString(inputLine, "<cID>>", "<eNR>>")));
        retrieved.setFirstName(inputLineToString(inputLine, "<fNm>>", "<lNm>>"));
        retrieved.setLastName(inputLineToString(inputLine, "<lNm>>", "<gdr>>"));
        retrieved.setGender(inputLineToString(inputLine, "<gdr>>", "<str>>"));
        retrieved.setStreet(inputLineToString(inputLine, "<str>>", "<hNr>>"));
        retrieved.setHouseNr(Integer.parseInt(inputLineToString(inputLine, "<hNr>>", "<zip>>")));
        retrieved.setZipCode(inputLineToString(inputLine, "<zip>>", "<cty>>"));
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<pin>>"));
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
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<pin>>"));
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
        retrieved.setCity(inputLineToString(inputLine, "<cty>>", "<pin>>"));
        retrieved.setPin(Integer.parseInt(inputLineToString(inputLine, "<pin>>", "#")));
        return retrieved;
    }

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

    public String inputLineToString(String inputLine, String regex1, String regex2){
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

    public void printDatabase(){
        ArrayList<String> inputLines = databaseCopy();

        if (inputLines == null)
            return;

        for (String inputLine : inputLines){
            System.out.println(inputLine);
        }

    }
}

