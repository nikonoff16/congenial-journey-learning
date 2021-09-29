import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class learnByTextBook {
    public static void main(String[] args) {
        SortedSet<String> testSet = new TreeSet<>(Arrays.asList(args));

        for (String word : testSet) {
            System.out.println(word);
        }

        String first = testSet.first();
        String last = testSet.last();

        SortedSet<String> tail = testSet.tailSet(first + '\0');
        System.out.println(tail);

        SortedSet<String> head = testSet.headSet(last);
        System.out.println(tail);

        SortedSet<String> middle = testSet.subSet(first + '\0', last);
        System.out.println(middle);

        List<String> testList = new ArrayList<String>(Arrays.asList(args));
        List<String> anotherList = Arrays.asList("first", "second");
        List<String> yetAnotherList = List.of("third", "four");
    }
}
