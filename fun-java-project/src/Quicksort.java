import java.util.Date;
import java.util.Random;

public class Quicksort {
    private static final String LocalTime = null;
    protected static Random rand = new Random();

    public static void main(String[] args) {
        int[] numbers = new int[10000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);
        }

        System.out.println("Before: " + new Date());
        // printArray(numbers);

        quicksort(numbers);

        System.out.println("\nAfter: " + new Date());
        // printArray(numbers);
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = rand.nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
