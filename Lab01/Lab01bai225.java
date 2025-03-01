import java.util.Scanner;
public class Lab01bai225 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double x= input.nextDouble();
		double y= input.nextDouble();
		double sum=x+y;
		System.out.println(sum);
		double difference = x-y;
		System.out.println(difference);
		double product= x*y;
		System.out.println(product);
		double quotient;
		if(y!=0) {
			quotient=x/y;
			System.out.println(quotient);
		}
		input.close();
	}
}
