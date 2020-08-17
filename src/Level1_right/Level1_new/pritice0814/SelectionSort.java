package Level1_right.Level1_new.pritice0814;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        selctionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void selctionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
           return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int MinIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                MinIndex = arr[MinIndex] < arr[j] ? MinIndex : j;
            }
            swap(arr, MinIndex, i);
        }
    }

    private static void swap(int[] arr, int minIndex, int i) {
        int tem = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tem;
    }
}
