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

    boolean Test(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (!isOdd(arr[i - 1]) && isOdd(arr[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Task2 task = new Task2();
        int arr[] = { 3, 4, 1, 2, 6, 7 };
        System.out.println("Before");
        System.out.println(Arrays.toString(arr));
        int updated[] = task.Sort(arr);
        System.out.println("After");
        System.out.println(Arrays.toString(updated));
        System.out.println();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int arr2[] = new int[10];
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = random.nextInt(50);
            }

            System.out.println("Before");
            System.out.println(Arrays.toString(arr2));
            updated = task.Sort(arr2);
            System.out.println("After");
            System.out.println(Arrays.toString(updated));
            System.out.println();
        }

    }

}
