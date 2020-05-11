// JDK >= 1.8

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Task {

    // mergeSort is STABLE
    void MergeSort(int arr[], int start, int end) {
        if (start < end - 1) {
            int middle = (start + end) / 2;
            MergeSort(arr, start, middle);
            MergeSort(arr, middle, end);
            Merge(arr, start, end);
        }
    }

    void Merge(int arr[], int start, int end) {
        int middle = (start + end) / 2;
        int left[] = Arrays.copyOfRange(arr, start, middle);
        int right[] = Arrays.copyOfRange(arr, middle, end);
        for (int i = 0, j = 0, k = start; k < end; k++) {
            if (i == left.length) {
                arr[k] = right[j++];
                continue;
            } else if (j == right.length) {
                arr[k] = left[i++];
                continue;
            }
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }
    }

    boolean isOdd(int a) {
        return Math.floorMod(a, 2) == 1;
    }

    // O(nlogn)
    void Sort(int arr[]) {
        // O(nlogn)
        // MergeSort(arr, 0, arr.length);
        Arrays.sort(arr);
        int odds[] = new int[arr.length];
        int evens[] = new int[arr.length];
        int j = 0;
        int k = 0;
        // O(n)
        for (int i = 0; i < arr.length; i++) {
            if (isOdd(arr[i])) {
                odds[j++] = arr[i];
            } else {
                evens[k++] = arr[i];
            }
        }
        // O(n)
        for (int i = 0; i < j; i++) {
            arr[i] = odds[i];
        }
        k = 0;
        // O(n)
        for (int i = j; i < arr.length; i++) {
            arr[i] = evens[k++];
        }
    }

    boolean TestPassed(int arr[]) {
        // Explanation,
        // I have divided the correctness of the program in exhaustive test cases
        boolean has_happend_once = false;
        for (int i = 1; i < arr.length; i++) {
            // the condition in for loop accounts for unit and null arrays
            if (!isOdd(arr[i - 1]) && !isOdd(arr[i]) && arr[i] - arr[i - 1] < 0) {
                // this accounts for a[i] >= a[j] if i > j
                // where i,j are indices and a[i],a[j] are values
                // essentially makes sure that array is sorted
                return false;
            } else if (isOdd(arr[i - 1]) && isOdd(arr[i]) && arr[i] - arr[i - 1] < 0) {
                // this accounts for a[i] >= a[j] if i > j
                // where i,j are indices and a[i],a[j] are values
                // essentially makes sure that array is sorted
                return false;
            } else if (isOdd(arr[i - 1]) && !isOdd(arr[i])) {
                // this condition will happen only once
                // essentially its the demarcation point b/w odd and even sorted numbers
                if (has_happend_once)
                    return false;
                has_happend_once = true;
            } else if (!isOdd(arr[i - 1]) && isOdd(arr[i])) {
                // this condition must not happen
                // this implies that evens occured before odds
                return false;
            }
        }
        // all elements have passed the above cases
        return true;
    }

    public static void main(String[] args) {
        Task task = new Task();
        Random random = new Random();
        for (int i = 0; i < 50; i++) { // increase this number (50) for more tests
            int arr[] = new int[random.nextInt(20)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(50) - random.nextInt(50);
            }
            task.Sort(arr); // IMP (comment this to see if test fail)
            System.out.println(Arrays.toString(arr));
            if (!task.TestPassed(arr)) {
                System.out.println("Test failed on");
                System.out.println(Arrays.toString(arr));
                break;
            }
        }
    }

}
