package Level1_right.Level1_new.pritice0814;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
           return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            int[] p = pritition(arr, l, r);
            quickSort(arr, 0, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] pritition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
               swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{ less + 1, more};
    }

    private static void swap(int[] arr, int i, int i1) {
        int tem = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tem;
    }


}
