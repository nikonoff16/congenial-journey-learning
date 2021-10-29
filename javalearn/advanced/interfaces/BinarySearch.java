public class BinarySearch {
    public static int findNumber(int[] numbers, int number) {
        int low = 0;
        int high = numbers.length;

        while (low <= high) {
            int mid = (high + low) / 2;
            int guess = numbers[mid];

            if (guess == number) {
                return mid;
            } 
            if (guess > number) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
