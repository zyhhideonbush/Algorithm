package Level1_right.Level1_new.pritice0814;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
           return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int MaxIndex = (left + 1) < size && arr[left + 1] > arr[left] ? left + 1 : left;
            MaxIndex = arr[MaxIndex] > arr[i] ? MaxIndex : i;
            if (MaxIndex == i) {
                break;
            }
            swap(arr, i, MaxIndex);
            i = MaxIndex;
            left = 2 * i + 1;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tem = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tem;
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
}
