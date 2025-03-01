import java.util.Arrays;
import java.util.Scanner;
public class lab01bai65 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.print("NHap mang: ");
        for(int i = 0; i < n; i++){
           arr[i] = input.nextInt();
           sum += arr[i]; 
        }
        double tb = (double)sum / n;
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.printf("Average value: %.1f", tb);
        input.close();
    }
}