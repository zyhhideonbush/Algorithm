package level2_right.level2_new.pritice0723;

public class Code05_RotateMatrix {
    public static void rotateMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a < c) {
            potateMatrix(arr, a++, b++, c--, d--);
        }
    }

    private static void potateMatrix(int[][] arr, int a, int b, int c, int d) {
        int times = c - a;
        int tem = 0;
        for(int i = 0; i != times; i++){
            tem = arr[a][b + i];
            arr[a][b + i] = arr[c - i][b];
            arr[c - i][b] = arr[c][d - i];
            arr[c][d - i] = arr[a + i][d];
            arr[a + i][d] = tem;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
