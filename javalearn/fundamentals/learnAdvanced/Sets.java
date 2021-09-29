import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<T>();

        Set<T> firstCopy = new HashSet<>(set1);
        Set<T> secondCopy = new HashSet<>(set2);

        firstCopy.removeAll(set2);
        secondCopy.removeAll(set1);

        result.addAll(firstCopy);
        result.addAll(secondCopy);

        return result;



    }
}
