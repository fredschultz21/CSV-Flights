// DO NOT REMOVE PACKAGE LINE
// Without this line the autograder will not run correctly
// You can comment it while you work on the problem
// When everything works - uncomment and submit!
package com.gradescope.hw;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Query8 {
    /*
    Starts by going through the FlightRecord and building up a linked list of every single
    possible destination state without any copies. Then, it iterates through that list of
    states able to be flown to. For every state, it counts up in an array of two integers
    how many intra state flight there are, and how many flights take off in that state.
    Then, it makes sure the answer won't be 0 because there would be no reason to add
    it to the final list, then it divides those two numbers as floats. It finally adds
    this number in the correct formant as a string to the final list.
     */
    public static Iterable<String> Query8(Iterable<FlightRecord> input) {
        int[] twonums = new int[2]; //1st number is number of non intraflights, 2nd is intraflights
        LinkedList<String> intostates = new LinkedList<>();
        LinkedList<String> thestatesfinal = new LinkedList<>();
        for (FlightRecord r : input) {
            if (!intostates.contains(r.DEST_STATE_ABR) ) {
                intostates.add(r.DEST_STATE_ABR);
            }
        }
        for (int i = 0; i < intostates.size(); i++) {
            twonums[0] = 0;
            twonums[1] = 0;
            String thestatewecheck = intostates.get(i);
            for (FlightRecord r : input) {
                if (r.ORIGIN_STATE_ABR.equals(thestatewecheck) && r.DEST_STATE_ABR.equals(thestatewecheck)) {
                    twonums[1] = twonums[1] + 1;
                    twonums[0] += 1;
                } else if (r.ORIGIN_STATE_ABR.equals(thestatewecheck)) {
                    twonums[0] = twonums[0] + 1;
                }
            }
            float answer;
            if (twonums[0] == 0) {
                answer = 0;
            } else {
                answer = (float) twonums[1] / (float) twonums[0];
            }
            DecimalFormat df = new DecimalFormat("#.000");
            if (answer != 0) {
                String withThreeDigits = df.format(answer);
                thestatesfinal.add(thestatewecheck + "=" + withThreeDigits);
            }
        }
        return thestatesfinal;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
        Iterable<String> rs = Query8(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
