package level5_right.pritice.pritice0805;

public class Code03_isLand {
    public static int idLand(int[][] arr) {
        if (arr == null || arr[0] == null) {
           return 0;
        }
        int N = arr.length;
        int M = arr[0].length;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    result++;
                    infect(arr, i, j, N, M);
                }
            }
        }
        return result;
    }

    private static void infect(int[][] arr, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] != 1) {
           return;
        }
        arr[i][j] = 2;
        infect(arr, i + 1, j, N, M);
        infect(arr, i - 1, j, N, M);
        infect(arr, i, j + 1, N, M);
        infect(arr, i, j - 1, N, M);
    }
}
