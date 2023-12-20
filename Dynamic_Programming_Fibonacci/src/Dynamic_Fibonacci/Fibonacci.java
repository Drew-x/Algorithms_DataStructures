package Dynamic_Fibonacci;

import java.util.Iterator;

public class Fibonacci {

	
	
	
	public int fib(int num) {
		
		
//		if(num == 1) {
//			
//			return 0;
//		}
		
		if(num <=2) {
			
			return 1;
		}
		
		//System.out.println( fib(num - 1) + fib(num - 2) );
		return fib(num - 1) + fib(num - 2);
		
	}
	
	
	//static int[] x = null ;
	
	public long fib2(int num, long[] x)  {
		
		 
		
		//System.out.println("leng"+ x.length);
		//System.out.println(x.toString());
		
//		for (int i = 0; i < x.length; i++) {
//			System.out.println(x[i]);
//		}
		
		if (x[num] != 0) {
			
			return x[num];
		}
		
		if(num <=2) {
			
			return 1;
		}
		
		x[num] = fib2(num - 1, x) + fib2(num - 2, x);
		
		return x[num];
		
	}
	
	
}
