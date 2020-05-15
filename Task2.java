import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Task2 {

    boolean isOdd(int a) {
        return Math.floorMod(a, 2) == 1;
    }

    int[] Sort(int[] arr) {
        int temp[] = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isOdd(arr[i]))
                temp[k++] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (!isOdd(arr[i]))
                temp[k++] = arr[i];
        }
        return temp;
    }

    boolean Test(int arr[], int orig[]) {
        int t1[] = new int[arr.length];
        int t2[] = new int[arr.length];
        int k = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            // demarcation point
            if ((i + 1) < arr.length && isOdd(arr[i]) && !isOdd(arr[i + 1])) {
                t1[l++] = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (isOdd(arr[j]))
                        return false;
                    // t2 contatins all evens
                    t2[k++] = arr[j];
                }
                break;
            }
            // this means even before odd
            else if ((i + 1) < arr.length && !isOdd(arr[i]) && isOdd(arr[i + 1]))
                return false;
            // t1 contains either all evens or all odds
            else
                t1[l++] = arr[i];
        }


        // checking for relative order
        int counter = 0;
        int m = 0;
        int n = 0;

        for (int i = 0; i < orig.length; i++) {
            if (m >= l)
                break;
            if (orig[i] == t1[m]) {
                counter++;
                m++;
            }
        }

        for (int i = 0; i < orig.length; i++) {
            if (n >= k)
                break;
            if (orig[i] == t2[n]) {
                counter++;
                n++;
            }
        }
        // this condition will never occur if relative order is not preserved.
        if (counter == orig.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        Task2 task = new Task2();
        int arr[] = { 3, 4, 1, 2, 6, 7 };
        System.out.print("Before: ");
        System.out.println(Arrays.toString(arr));
        int updated[] = task.Sort(arr);
        System.out.print("After: ");
        System.out.println(Arrays.toString(updated));
        System.out.println("Test Passed: " + task.Test(updated, arr));
        System.out.println();
        /////////////////////////////////////
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int arr2[] = new int[10];
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = random.nextInt(10);
            }

            System.out.print("Before: ");
            System.out.println(Arrays.toString(arr2));
            updated = task.Sort(arr2);
            System.out.print("After: ");
            System.out.println(Arrays.toString(updated));
            System.out.println("Test Passed: " + task.Test(updated, arr2));
            System.out.println();
        }

    }

}
