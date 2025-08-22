import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Query6 {
    /*
    A map is initialized which will take the string representations of origins
    and destination states, and will count up how many of each of these pairs
    there are. Every time there is a new pair, the pair is set to value 1.
    When it's already in the map, 1 is added to the value of the existing pair.
    Then, this map is iterated over. It looks for a new max value, and if it finds one,
    it sets themax to that new max, and thestates to the string representation.
    Then it returns the state pair with the most flight between.
     */
    public static String Query6(Iterable<FlightRecord> input) {
        Map<String, Integer> tofromstatenum = new HashMap<>();
        for (FlightRecord r : input) {
            String stringrep = "(" + r.ORIGIN_STATE_ABR + "," + r.DEST_STATE_ABR + ")";
            if (tofromstatenum.containsKey(stringrep)) {
                tofromstatenum.put(stringrep, tofromstatenum.get(stringrep) + 1);
            } else {
                tofromstatenum.put(stringrep, 1);
            }
        }
        Integer themax = 0;
        String themaxstatepair = "";
        for (Map.Entry<String, Integer> entry : tofromstatenum.entrySet()) {
            if (entry.getValue() > themax) {
                themax = entry.getValue();
                themaxstatepair = entry.getKey();
            }
        }
        return themaxstatepair;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
        String r = Query6(input);
        System.out.println(r);
    }
}
