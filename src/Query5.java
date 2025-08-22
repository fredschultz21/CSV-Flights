import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Query5 {
    /*
    Creates a map to count up the numbers of flights in each month. Then goes
    over all of FlightRecord. If the month is already in the map, increase the value
    by 1. If not, add it, and set its value to 1. Then, iterate over that entire map
    looking for the key with the largest value. Every time a bigger value is found, the max
    is set to that value, and the number representing the month is kept in an integer. Then
    a string is returned in the correct format.
     */
    public static String Query5(Iterable<FlightRecord> input) {
        Map<Integer, Integer> monthflightnums = new HashMap<>();
        for (FlightRecord r : input) {
            if (monthflightnums.containsKey(r.MONTH)) {
                monthflightnums.put(r.MONTH, (int) monthflightnums.get(r.MONTH) + 1);
            } else {
                monthflightnums.put(r.MONTH, 1);
            }
        }
        Integer themax = 0;
        Integer themonth = 0;
        for (Map.Entry<Integer, Integer> entry : monthflightnums.entrySet()) {
            if (entry.getValue() > themax) {
                themax = entry.getValue();
                themonth = entry.getKey();
            }
        }
        return themonth + " had " +  themax + " flights";
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
        String r = Query5(input);
        System.out.println(r);
    }
}
