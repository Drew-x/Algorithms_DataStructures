package Dynamic_Fibonacci;

import java.util.Scanner;

public class Fibonacci_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner;
		int num = 0;

		while (num != -1) {
			
			System.out.println("Enter fib");
			scanner = new Scanner(System.in);
			num = scanner.nextInt();
			
			Fibonacci fibonacci = new Fibonacci();
			long[] x = new long[(int) (num+1)];
			
			System.out.println(fibonacci.fib2(num,x));
			
		}
	}

}
