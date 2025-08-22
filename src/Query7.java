import java.io.IOException;
import java.util.*;

public class Query7 {
    /*
    Creates a linked list that contains strings for every single possible destination state,
    only adding them once by making sure they haven't already been added. Then, it goes
    through the entire FlightRecord. If there is an origin in Iowa, it deletes the destination
    state from the list states, because that means that it is in fact possible to get to that destination
    state from Iowa. If the state isn't in states, .remove() will just do nothing. Then,
    it returns the states which you can't get to in 1 flight from Iowa.
     */
    public static Iterable<String> Query7(Iterable<FlightRecord> input) {
        LinkedList<String> states = new LinkedList<>();
        for (FlightRecord r : input) {
            if (!states.contains(r.DEST_STATE_ABR) ) {
                states.add(r.DEST_STATE_ABR);
            }
        }
        for (FlightRecord r : input) {
            if (r.ORIGIN_STATE_ABR.equals("IA")) {
                states.remove(r.DEST_STATE_ABR);
            }
        }
        return states;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
        Iterable<String> rs = Query7(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
