package Level1_right.Level1_new.pritice0813;


public class Code03_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            int MinIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                MinIndex = arr[MinIndex] < arr[j] ? MinIndex : j;
            }
            swap(arr, MinIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int res = arr[i];
        arr[i] = arr[j];
        arr[j] = res;
    }
}
