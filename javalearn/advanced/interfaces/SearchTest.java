public class SearchTest {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,8,10,20,21,100};

        int findPosition = BinarySearch.findNumber(numbers, 11);

        System.out.println(findPosition);
    }
}
