import java.util.*;
import java.util.function.*;

public class PrintSortedLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int count = 0;

        String rawNums = scanner.nextLine();
        String[] listRawNumb = rawNums.strip().split(" ");
        for (String num : listRawNumb) {
            try {
                int middleResult = Integer.parseInt(num);
                if (count % 2 != 0) {
                    numbers.add(middleResult);
                }
                count++;

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        Collections.reverse(numbers);

        for (int item : numbers) {
            System.out.print(item + " ");
        }

    }
}

