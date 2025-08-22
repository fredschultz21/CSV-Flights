// DO NOT REMOVE PACKAGE LINE
// Without this line the autograder will not run correctly
// You can comment it while you work on the problem
// When everything works - uncomment and submit!
package com.gradescope.hw;

import java.io.IOException;
import java.util.*;

public class Query9 {
    /*
    A list of all destination states possible is made, only adding the states
    if they aren't in the list. Then, for every state in that list, a map is built up
    with airlines as keys and values as number of times that the airline has flown into
    the state. Then, that map is iterated over to see which airline had the most
    flights into that state, and that airline is put into a map with the state. The map
    continues to build up with keys as states and values as airlines. Finally, that
    map is looped over to build a list of strings in the correct format.
     */
    public static Iterable<String> Query9(Iterable<FlightRecord> input) {
        Map<String, Integer> checkmap = new HashMap<>();
        Map<String, String> finalmap = new HashMap<>();
        LinkedList<String> intostates = new LinkedList<>();
        LinkedList<String> answer = new LinkedList<>();
        for (FlightRecord r : input) {
            if (!intostates.contains(r.DEST_STATE_ABR) ) {
                intostates.add(r.DEST_STATE_ABR);
            }
        }
        for (int i = 0; i < intostates.size(); i++) {
            String thestate = intostates.get(i);
            checkmap.clear();
            String carrier = "";
            int bestto = 0;
            for (FlightRecord r : input) {
                if (r.DEST_STATE_ABR.equals(thestate)) {
                    if (checkmap.containsKey(r.UNIQUE_CARRIER_NAME)) {
                        checkmap.put(r.UNIQUE_CARRIER_NAME, checkmap.get(r.UNIQUE_CARRIER_NAME) + 1);
                    } else {
                        checkmap.put(r.UNIQUE_CARRIER_NAME, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : checkmap.entrySet()) {
                if (entry.getValue() > bestto) {
                    bestto = entry.getValue();
                    carrier = entry.getKey();
                }
            }
            finalmap.put(intostates.get(i), carrier);
        }
        for (Map.Entry<String, String> entry : finalmap.entrySet()) {
            String transfer = entry.getKey() + "," + entry.getValue();
            answer.add(transfer);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2005.csv");
        Iterable<String> rs = Query9(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
