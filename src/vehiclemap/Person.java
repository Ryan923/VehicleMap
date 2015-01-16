package vehiclemap;

import java.util.ArrayList;

public class Person {
/**
 * A simple object, representing a vehicle owner, 
 * with room for expansion. 
 */
    public static class Info {
        String name_full;
        String name_first;  // not used, but potentially useful
        String name_last;   // not used, but potentially useful
        ArrayList<String> ownedVehicles = new ArrayList<String>();
    }
    
}
