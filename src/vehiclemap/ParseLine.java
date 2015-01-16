package vehiclemap;
import java.io.IOException;
import java.util.ArrayList;

public class ParseLine {
/**
 * These methods parse given strings and return substrings or lists
 * of whatever portion of the string each is looking for.
 */

    public static String get_leftOfEqual(String line) {
    /**
     * Parses given string and returns everything left 
     * of the equal operator.
     */
        String id_person = "-1";
        // getting our substring...
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '=') {
                id_person = line.substring(0, i);
                break;
            }
        }
        
        return id_person;
    }//end get_leftOfEqual()
    
    public static String get_rightOfEqual(String line) {
    /**
     * Parses given string and returns everything right 
     * of the equal operator.
     */
        String cars = "-1";
        // getting our substring...
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '=') {
                cars = line.substring(i + 1, line.length());
            }
        }
        
        return cars;
    }//end get_rightOfEqual

    public static ArrayList<String> get_carNames(String line, ArrayList<String> carList) {
    /**
     * Parses our string of car IDs and returns a list of
     * corresponding names.
     */
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> carIDs = get_carIDs(line);
        // Getting car names by ID
        for (int i = 0; i < carIDs.size(); i++) {
            for (int j = 0; j < carList.size(); j++) {
                if (carIDs.get(i).equalsIgnoreCase(get_leftOfEqual(carList.get(j)))) {
                    list.add(get_rightOfEqual(carList.get(j)));
                }
            }
        }//end for
        
        return list;
    }//end get_carNames()

    public static ArrayList<String> get_carIDs(String line) {
    /**
     * Parses our string of car IDs and returns them as a list.
     */
        ArrayList<String> carIDs = new ArrayList<String>();
        String temp = line;
        int i = line.length();
        // Using comma separators to distinguish IDs
        while (i > 0) {
            if (temp.contains(",")) {
                carIDs.add(temp.substring(0, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1, temp.length());
            } else {
                carIDs.add(temp);
                temp = "";
            }
            i = temp.length();
        }
        
        return carIDs;
    }//end get_carIDs()

    public static ArrayList<String> get_fileLines(String filepath) {
    /**
     * Attempts to get our list from the given file
     */
        ArrayList<String> list = new ArrayList<String>();
        try {
            ReadFile file = new ReadFile(filepath);
            list = file.LoadFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }//end get_fileLines()
}
