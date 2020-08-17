 package level2_right;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int endH = matrix.length - 1;
		int endL = matrix[0].length - 1;
		boolean fromUp = false;
		while (a != endH + 1) {
			printLevel(matrix, a, b, c, d, fromUp);
			a = b == endL ? a + 1 : a;
			b = b == endL ? b : b + 1;
			d = c == endH ? d + 1 : d;
			c = c == endH ? c : c + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int a, int b, int c, int d,
			boolean f) {
		if (f) {
			while (a != c + 1) {
				System.out.print(m[a++][b--] + " "); 
			}
		} else {
			while (c != a - 1) {
				System.out.print(m[c--][d++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
