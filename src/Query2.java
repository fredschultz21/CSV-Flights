// DO NOT REMOVE PACKAGE LINE
// Without this line the autograder will not run correctly
// You can comment it while you work on the problem
// When everything works - uncomment and submit!
package com.gradescope.hw;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Query2 {

    /*
    Creates a set so there won't be repeat values. Goes over the entire FlightRecord
    adding the destination to the set if the origin is CID, while formatting the answer
    correctly. Then, it returns the set.
     */
    public static Iterable<String> Query2(Iterable<FlightRecord> input) {
        Set<String> destinations = new HashSet<>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID")) {
                String answer = "";
                answer += r.DEST + ", " + r.DEST_STATE_ABR;
                destinations.add(answer);
            }
        }
        return destinations;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2005.csv");
        Iterable<String> results = Query2(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
