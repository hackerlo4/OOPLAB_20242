import java.util.Scanner;

public class lab01bai66 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap size m x n: ");
        System.out.print("m = ");
        int m = input.nextInt();
        System.out.print("n = ");
        int n = input.nextInt();
        int[][] mt = new int[m][n];
        System.out.println("ma tran 1:  ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mt[i][j] = input.nextInt();
            }
        }
        System.out.println("ma tran 2: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mt[i][j] += input.nextInt();
            }
        }

        System.out.println("tong: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mt[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}
