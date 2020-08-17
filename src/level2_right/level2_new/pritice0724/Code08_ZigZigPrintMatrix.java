package level2_right.level2_new.pritice0724;

public class Code08_ZigZigPrintMatrix {
    public static void zigPrintMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int endH = arr.length - 1;
        int endL = arr[0].length - 1;
        boolean bo = false;
        while (a >= c) {
            zigPrintMatrix(arr, a, b, c, d, endH, endL, bo);
            b = a == endH ? b + 1 : b;
            a = a == endH ? a : a + 1;
            c = d == endL ? c + 1 : c;
            d = d == endL ? d : d + 1;
            bo = !bo;
        }
    }

    private static void zigPrintMatrix(int[][] arr, int a, int b, int c, int d, int endH, int endL, boolean bo) {
        if (bo) {
            while (a >= c) {
                System.out.print(arr[a--][b++]);
            }
        } else {
            while (c <= a) {
                System.out.print(arr[c++][d--]);
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigPrintMatrix(matrix);

    }

}
