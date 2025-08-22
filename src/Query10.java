import java.io.IOException;
import java.util.*;

public class Query10 {
    /*
    A list is made of all possible destinations. Then, that list is iterated over,
    and it's added to a new list if that destination can fly to LAX. It breaks after,
    because we know that it can go to LAX, and there's no reason to keep checking.
    The answers are correctly formatted, and the list is returned.
     */
    public static Iterable<String> Query10(Iterable<FlightRecord> input) {
        LinkedList<String> thestatesfinal = new LinkedList<>();
        LinkedList<String> finalanswer = new LinkedList<>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID") && !thestatesfinal.contains(r.DEST)) {
                thestatesfinal.add(r.DEST);
            }
        }
        for (int i = 0; i < thestatesfinal.size(); i++) {
            String theorigin = thestatesfinal.get(i);
            for (FlightRecord r : input) {
                if (r.ORIGIN.equals(theorigin) && r.DEST.equals("LAX")) {
                    finalanswer.add("CID->" + theorigin + "->LAX");
                    break;
                }
            }
        }
        return finalanswer;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights2020.csv");
        Timer t = new Timer();
        t.start();
        Iterable<String> results = Query10(input);
        t.end();
        for (String s : results) {
            System.out.println(s);
        }
        System.out.println(t.elapsedSeconds());
    }
}
