package Level1_right.Level1_new.pritice0816;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                maxIndex = arr[maxIndex] < arr[j] ? maxIndex : j;
            }
            swap(arr, maxIndex, i);
        }
    }

    private static void swap(int[] arr, int maxIndex, int i) {
        int tem = arr[maxIndex];
        arr[maxIndex] = arr[i];
        arr[i] = tem;
    }
}
