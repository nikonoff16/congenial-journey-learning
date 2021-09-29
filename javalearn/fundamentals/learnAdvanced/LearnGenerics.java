import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnGenerics {
    public static void main(String[] args) {
        String[] input = {"tiger", "cat", "TIGER", "leopard", "Tiger"};

        List<String> cats = Arrays.asList(input);
        String search = "tiger";

        String tigers = cats.stream()
                            .filter(s -> s.equalsIgnoreCase(search))
                            .collect(Collectors.joining(", "));

        System.out.println(tigers);

        List<Integer> namesLengh = cats.stream()
                                       .map(String::length)
                                       .collect(Collectors.toList());

        System.out.println(namesLengh);

        List<String> pets = List.of("dog", "cat", "fish", "fox", "rat", "baby", "wife");

        pets.stream().forEach(System.out::println);

        double sumPrimes = ((double) Stream
                                        .of(2, 3, 5, 7, 11, 13, 17, 19, 23)
                                        .reduce(0, (x, y) -> {return x + y;}));
        System.out.println("Sum of some primes: " + sumPrimes);

    }
    
}
