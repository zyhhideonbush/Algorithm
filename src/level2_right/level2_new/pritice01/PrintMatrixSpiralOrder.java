package level2_right.level2_new.pritice01;

public class PrintMatrixSpiralOrder {
	public static void PrintMatrix(int[][] arr){
		int a = 0 ;
		int b = 0 ;
		int c = arr.length-1 ;
		int d = arr[0].length-1 ;
		while(a<=c&&b<=d){
			PrintMa(arr,a++,b++,c--,d--) ;
		}
		
	}

	private static void PrintMa(int[][] arr, int a, int b, int c, int d) {
		if(a==c){
			while(b<=d){
				System.out.print(arr[a][b]+" ");
				b++ ;
			}
		}else if(b==d){
			while(a<=c){
				System.out.print(arr[a][b]+" ");
				a++ ;
			}
		}else{
			int curH = a ;
			int curL = b ;
			while(curL!=d){
				System.out.print(arr[a][curL]+" ");
				curL++ ;
			}
			while(curH!=c){
				System.out.print(arr[curH][d]+" ");
				curH++ ;
			}
			while(curL!=b){
				System.out.print(arr[c][curL]+" ");
				curL-- ;
			}
			while(curH!=a){
				System.out.print(arr[curH][b]+" ");
				curH-- ;
			}
		}
		
		
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		PrintMatrix(matrix);

	}
}
