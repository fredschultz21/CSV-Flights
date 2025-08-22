import java.io.IOException;
import java.util.*;

public class Query4 {

    /*
    Creates a map to hold the destinations and the numbers. Goes over the entire
    FlightRecord looking for origins of CID, then checking if that destination
    has already been but into the map, and increasing the value by 1 if it has been.
    If not, then it puts it into the map with a value of 1. Then, it creates a set
    to format the answers correctly, creating a string with the key and value each time.
    Then it returns the set.
     */
    public static Iterable<String> Query4(Iterable<FlightRecord> input) {
        Map<String, Integer> destnumbers = new HashMap<>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID")) {
                if (destnumbers.containsKey(r.DEST)) {
                    destnumbers.put(r.DEST, destnumbers.get(r.DEST) + 1);
                } else {
                    destnumbers.put(r.DEST, 1);
                }
            }
        }
        Set<String> finaldestnum = new HashSet<>();
        for (Map.Entry<String, Integer> entry : destnumbers.entrySet()) {
            String mystring = "";
            mystring += entry.getKey() + "=" + entry.getValue();
            finaldestnum.add(mystring);
        }
        return finaldestnum;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2005.csv");
        Iterable<String> results = Query4(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
