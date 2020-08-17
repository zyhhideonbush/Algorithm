package Level1_right.Level1_new.pritice0720;

import java.util.Arrays;

public class Code11_MathGap {
    public static int getMathGap(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int len = arr.length;
        for(int i = 0; i<len; i++){
            maxNum = Math.max(arr[i], maxNum);
            minNum = Math.min(arr[i], minNum);
        }
        if(maxNum == minNum){
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxPool = new int[len + 1];
        int[] minPool = new int[len + 1];
        for(int i = 0; i < len; i++){
            int bid = bucketNum(arr[i], len, minNum, maxNum);
            minPool[bid] = hasNum[bid] && minPool[bid] < arr[i] ? minPool[bid] : arr[i];
            maxPool[bid] = hasNum[bid] && maxPool[bid] > arr[i] ? maxPool[bid] : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxPool[0];
        for(int i = 0; i <= len; i++){
            if(hasNum[i]){
                res = Math.max(minPool[i] - lastMax,res);
                lastMax = maxPool[i];
            }
        }
        return res;
    }

    private static int bucketNum(int num, int len, int minNum, int maxNum) {
        return ((num - minNum) * len / (maxNum - minNum));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (getMathGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
