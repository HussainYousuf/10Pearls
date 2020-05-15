public class Task2 {

    int[] Sort(int[] arr){
        int temp[] = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isOdd(arr[i])) temp[k++] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if(!isOdd(arr[i])) temp[k++] = arr[i];
        }
        return temp;
    } 
    
    boolean Test(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if(!isOdd(arr[i-1]) && isOdd(arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    
        Task task = new Task();
        int arr[] = {3,4,1,2,6,7};
        System.out.println(Arrays.toString(task.Sort(arr)));
        
    }

}


