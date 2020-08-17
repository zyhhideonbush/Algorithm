package Level1_right.Level1_new.pritice0814;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length -i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                   swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tem = arr[j];
        arr[j] = arr[i];
        arr[i] = tem;
    }
}
