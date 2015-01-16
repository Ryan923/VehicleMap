package vehiclemap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
// Output
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;


public class Report {
    
    public static void print(ArrayList<Person.Info> p) {
    /**
     * Generates a text file in the text_files folder from
     * the received list of information.
     */
        Writer writer = null;
        Date date = new Date();
        String output = new String();
        // Assembling our header...
        output += String.format("%5s\n\n", date.toString());
        output += String.format("%30s\n\n", "Vehicle Ownership Report");
        output += String.format("%-25s%-25s\n", "OWNER", "VEHICLES");
        // Assembling our info...
        for (int i=0; i<p.size(); i++) {
            output += String.format("%-25s%-25s\n", p.get(i).name_full, p.get(i).ownedVehicles);
        }
        // Creating our text file
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("text_files/report.txt"), "utf-8"));
            writer.write(output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }         
        if (VehicleMap.DEBUG)   System.out.println(output);     // printing to console
    }//end print()
    
}//end file
