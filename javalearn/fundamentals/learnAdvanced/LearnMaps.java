import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class LearnMaps {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();

        Map<String, Integer> singleTon = Collections.singletonMap("test", -1);
        Map<String, Integer> empty = Collections.<String, Integer>emptyMap();

        String[] words = {"this", "is", "a", "test"};

        for (int i = 0; i < words.length; i++) {
            m.put(words[i], i);
        } 
        
        for (int i = 0; i < words.length; i++) {
            m.put(words[i].toUpperCase(), i);
        }

        m.putAll(singleTon);

        System.out.println(m);

        // Map<String, Double> capitals = Map.of("Moscow", 11.2, "St. Petersburg", 8.0);
        Map<String, Double> capitals = Map.ofEntries(Map.entry("Moscow", 11.2), Map.entry("St. Petersburg", 8.0));

        System.out.println(capitals);
    }
}
