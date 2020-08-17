package level2_right.level2_new.pritice0723;

public class Code06_PrintMatrixSpieralOrder {

    public static void PrintMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a < c && b < d) {
            print(arr, a++, b++, c--, d--);
        }
    }

    private static void print(int[][] arr, int a, int b, int c, int d) {
        if (a == c) {
            while (b <= d) {
                System.out.println(arr[a][b++]);
            }
        } else if (b == d) {
            while (a <= c) {
                System.out.println(arr[a++][b]);
            }
        } else {
            int cH = a;
            int cL = b;
            while(cL < d) {
                System.out.println(arr[a][cL]);
                cL++;
            }
            while(cH < c) {
                System.out.println(arr[cH][d]);
                cH++;
            }
            while(cL > b) {
                System.out.println(arr[c][cL]);
                cL--;
            }
            while(cH > a) {
                System.out.println(arr[cH][b]);
                cH--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        PrintMatrix(matrix);

    }
}
