import java.io.IOException;
import java.util.*;

public class Query3 {

    /*
    Creates a set of string so there aren't repeat values. Goes over the
    entirety of FlightRecord, adding a destination if the origin is CID.
    Then, returns the size of the set.
     */
    public static int Query3(Iterable<FlightRecord> input) {
        Set<String> destinations = new HashSet<>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID")) {
                destinations.add(r.DEST);
            }
        }
        return destinations.size();
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
        int results = Query3(input);
        System.out.println(results);
    }
}
