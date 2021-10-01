import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SublastEx {
    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        StringBuilder words = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            words.append(line);
            words.append(System.lineSeparator());
        }

        String preparedWords = words.toString().toLowerCase();
        List<String> listWords = Arrays.asList(preparedWords.split("[\\p{Punct}\\s]+"));
        
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = listWords.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey)) 
                .sorted(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()).reversed()) 
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

                

        
        finalMap.entrySet().stream()
                .map(e -> e.getKey())
                .limit(10)
                .forEach(System.out::println);

    }

}
