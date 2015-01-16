package vehiclemap;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This program reads three files from the text_files folder and
 * produces a report matching vehicles with their owners
 * 
 * Ryan Gillarde
 */
public class VehicleMap {
    
    public static final boolean DEBUG = true;                       // set as true for console output

    public static void main(String[] args) throws IOException {
        run();
    }//end main()
    
    public static void run() {
    /**
     * Gathers info and sends to Report for printing
     */
        String filePath_people_vehicles = "text_files/people_vehicles.txt";
        String filePath_vehicles        = "text_files/vehicles.txt";
        String filePath_people          = "text_files/people.txt";  
        ArrayList<Person.Info> people_info = new ArrayList<Person.Info>();
        String id_cars      = "-1";
        // Converting file contents to lists
        ArrayList<String> lines_people          = ParseLine.get_fileLines(filePath_people);
        ArrayList<String> lines_vehicles        = ParseLine.get_fileLines(filePath_vehicles);
        ArrayList<String> lines_people_vehicles = ParseLine.get_fileLines(filePath_people_vehicles);
        // Assembling info 
        for (int i=0; i<lines_people.size(); i++) {
            id_cars = ParseLine.get_rightOfEqual(lines_people_vehicles.get(i));
            Person.Info p = new Person.Info();
            p.name_full = ParseLine.get_rightOfEqual(lines_people.get(i));
            p.ownedVehicles = ParseLine.get_carNames(id_cars, lines_vehicles);
            people_info.add(p);
        }//end for
        // Printing report
        Report.print(people_info);
    }//end run()
    
 }//end file
