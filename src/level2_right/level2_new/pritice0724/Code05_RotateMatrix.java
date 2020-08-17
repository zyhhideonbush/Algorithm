package level2_right.level2_new.pritice0724;

public class Code05_RotateMatrix {
    public static void rotateMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a <= c && b <= d) {
            print(arr, a++, b++, c--, d--);
        }
    }

    private static void print(int[][] arr, int a, int b, int c, int d) {
        int curH = a;
        int curL = b;
        if (a == c) {
            while (curL <= d) {
                System.out.print(arr[a][curL++]+" ");
            }
        } else if (b == d) {
            while(curH <= c) {
                System.out.print(arr[curH++][b]+" ");
            }
        } else {
            while (curL < d) {
                System.out.print(arr[a][curL++]+" ");
            }
            while (curH < c) {
                System.out.print(arr[curH++][d]+" ");
            }
            while (curL > b) {
                System.out.print(arr[c][curL--]+" ");
            }
            while (curH > a) {
                System.out.print(arr[curH--][b]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotateMatrix(matrix);

    }
}
