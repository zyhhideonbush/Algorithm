package Level1_right.Level1_new.pritice01;

public class Code08_NetherlandsFlag {
    public static int[] partition(int[] arr, int l, int r, int num){
        int less = l - 1;
        int more = r + 1;
        while(l < more){
            if (arr[l] < num) {
                swap(arr, ++less, l++);
            } else if (arr[l] > num){
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    private static void swap(int[] arr, int i, int i1) {
        int tem = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tem;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
