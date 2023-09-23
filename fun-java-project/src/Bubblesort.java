import java.util.Random;

public class Bubblesort {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000_000);
        }

        System.out.println("Before: ");
        // printArray(numbers);

        // sort algorithm here
        boolean swappedNumber = true;

        while (swappedNumber) {
            swappedNumber = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if(numbers[i] > numbers[i + 1]) {
                    swappedNumber = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        System.out.println("After: ");
        // printArray(numbers);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
}
