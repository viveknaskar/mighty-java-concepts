import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstDuplicateElementFromAString {

    public static void main(String[] args) {

        String phrase = "this is the best day of my life";

        String firstDuplicateElement = Arrays.stream(phrase.trim().split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .findFirst().get().getKey();

        System.out.println("The first duplicate element: " + firstDuplicateElement);
    }
}
