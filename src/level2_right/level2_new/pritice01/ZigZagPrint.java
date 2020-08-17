package level2_right.level2_new.pritice01;

public class ZigZagPrint {
	public static void PrintZigZag(int[][] arr){
		int a = 0 ;
		int b = 0 ;
		int c = 0 ;
		int d = 0 ;
		int endH = arr.length-1 ;
		int endL = arr[0].length-1 ;
		boolean onetwo = false ;
		while(a!=endH+1){
			printZig(arr,a,b,c,d,onetwo) ;
			a = b == endL ? a+1 : a ;
			b = b == endL ? b : b+1 ;
			d = c == endH ? d+1 : d ;
			c = c == endH ? c : c+1 ;
			onetwo = !onetwo ;
		}
		System.out.println();
 	}

	private static void printZig(int[][] arr, int a, int b, int c, int d, boolean onetwo) {
		if(onetwo){
			while(a!=c+1){
				System.out.print(arr[a++][b--]+" ");
			}
		}else{
			while(c!=a-1){
				System.out.print(arr[c--][d++]+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		PrintZigZag(matrix);

	}
}
