package level3_right.level3_new.pritice0802;

import java.util.Scanner;

public class testScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] num = new int[size][size];
        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.print(num[2][0]);
        System.out.print(num[2][1]);
        System.out.print(num[2][2]);
    }
}
