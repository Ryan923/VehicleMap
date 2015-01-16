package vehiclemap;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadFile {
/**
 * Methods used when reading data from our text files
 */
    public ReadFile(String file_path) {
        path = file_path;
    }
    
    private String path;
    
    public ArrayList<String> LoadFile() throws IOException {
    /**
     * Assembles our list
     */
        ArrayList<String> fileText = new ArrayList<String>();
        FileReader fr = new FileReader(path);                       // reads characters
        BufferedReader textReader = new BufferedReader(fr);         // holds characters in memory
        // Building our list...
        for(int i=0; i<readLines(); i++) {                   
            fileText.add(textReader.readLine());
            if (fileText.get(i) == null) {
                fileText.remove(i);
                break;
            }
        }//end for
        textReader.close();
        
        return fileText;
    }//end LoadFile()
    
    int readLines() throws IOException {
    /**
     * Gets the # of lines our text file has
     */
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);
        
        String aLine;
        int numberOfLines = 0;
        
        while ( (aLine = bf.readLine()) != null) {              // stopping at last line
            numberOfLines++;
        }
        bf.close();
        
        return numberOfLines;
    }//end readLines()
}//end file
