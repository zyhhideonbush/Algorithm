package Level1_right.Level1_new.pritice02;

import java.util.Arrays;

public class maxGap {
	public static int maxgap(int[] nums){
		if(nums==null||nums.length<2){
			return 0 ;
		}
		int len = nums.length ;
		int min = Integer.MAX_VALUE ;
		int max = Integer.MIN_VALUE ;
		for(int i=0 ; i<len ; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if(min==max) return 0 ;
		boolean HasNum[] = new boolean[len+1] ;
		int mins[] = new int[len+1] ;
		int maxs[] = new int[len+1] ;
		int bid = 0 ;
		for(int i=0 ; i<len ; i++){
			bid = bucket(nums[i], len, min, max) ;
			mins[bid] = HasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i] ;
			maxs[bid] = HasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i] ;
			HasNum[bid] = true ;
		}
		int i=1 ;
		int res = 0 ;
		int lastMax = maxs[0] ;
		for( ; i<=len ; i++){
			if(HasNum[i]){
				res = Math.max(res, mins[i]-lastMax) ;
				lastMax = maxs[i] ;
			}
		}
		return res ;
	}

	private static int bucket(long num, long len, long min, long max) {
		return (int) ((num-min)*len/(max-min));
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
				if (maxgap(arr1) != comparator(arr2)) {
					succeed = false;
					break;
				}
			}
			System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		}

}
