package Level1_right.Level1_new.pritice0813;

public class Code02_InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,7,5,3,87,45,7,3,4};
        insertSort(arr);
        for (int i= 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
           return;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
