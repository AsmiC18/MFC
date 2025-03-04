import java.util.Arrays;

public class SortingComparison {

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Shift elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;  // Place key in its correct position
        }
    }

    public static void main(String[] args) {
        // Example array to demonstrate sorting algorithms
        int[] exampleArray = {5, 3, 8, 4, 2};

        // Measure time for Bubble Sort
        int[] bubbleArray = Arrays.copyOf(exampleArray, exampleArray.length);
        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleArray) + " | Time taken: " + (endTime - startTime) + " ns");

        // Measure time for Selection Sort
        int[] selectionArray = Arrays.copyOf(exampleArray, exampleArray.length);
        startTime = System.nanoTime();
        selectionSort(selectionArray);
        endTime = System.nanoTime();
        System.out.println("Selection Sort: " + Arrays.toString(selectionArray) + " | Time taken: " + (endTime - startTime) + " ns");

        // Measure time for Insertion Sort
        int[] insertionArray = Arrays.copyOf(exampleArray, exampleArray.length);
        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray) + " | Time taken: " + (endTime - startTime) + " ns");

        // Time Complexity: All algorithms are O(n²) in the worst case
    }
}
