package Level1_right.Level1_new.pritice0814;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        bucketSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int MaxNum = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++) {
            MaxNum = Math.max(arr[i], MaxNum);
        }
        int[] bucket = new int[MaxNum + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}
