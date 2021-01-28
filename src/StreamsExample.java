import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StreamsExample {
    /**
     * Streams have been introduced from Java 8 and is used basically to perform operations on a
     * collection of objects
     */

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Microsoft");
        list.add("Google");
        list.add("Tesla");
        list.add("Amazon");

        /**
         *  Traditional Approach: Without Streams, we needed to iterate over the collection
         *  then do a conditional check and then count
         */

        int countWithoutUsingStreams = 0;

        for (String num : list) {
            if(num.length() > 5) {
                countWithoutUsingStreams ++;
            }
        }
        System.out.println("Count Without Using Streams: " + countWithoutUsingStreams);

        /**
         * Streams incorporate something called Parallel execution
         *  of Operations which drastically improves the performance of the code.
         *  Iteration, Filtering and Counting occur in parallel
         */

        long countUsingStreams = list.stream().filter(num -> num.length() > 5).count();
        System.out.println("Count Using Streams: " + countUsingStreams);

    }
}
