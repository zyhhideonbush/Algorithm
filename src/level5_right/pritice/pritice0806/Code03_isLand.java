package level5_right.pritice.pritice0806;

public class Code03_isLand {
    public static int isLand(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return 0;
        }
        int M = arr.length;
        int N = arr[0].length;
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    result++;
                    effect(arr, i, j, M, N);
                }
            }
        }
        return result;
    }

    private static void effect(int[][] arr, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        effect(arr, i + 1, j, M, N);
        effect(arr, i - 1, j, M, N);
        effect(arr, i, j + 1, M, N);
        effect(arr, i, j - 1, M, N);
    }

    public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(isLand(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(isLand(m2));

	}
}
