package Dynamic_CanSum;

public class CanSum_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {5,3,4,7};
		//int[] array = {2,3,5};
		//int[] array = {2,4};
		//int[] array = {7,14};
		int target = 7;
		boolean[] memo = new boolean[302];
		//System.out.println(memo.length);
		boolean x = canSum(target, array, memo);
		System.out.println(x);
		
		
		for (int i = 0; i < memo.length; i++) {
			//System.out.println(memo[i]);
		}
		
	}
	
	public static boolean canSum(int target, int[] array, boolean[] memo) {
		//System.out.println("top"+ memo[target]);
		
		//System.out.println("over");
		if (memo[target] == true) {
			
			return true;
		}
		
		if (target == 0) {
			
			return true;
		}
		
		if (target < 0) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			
			int remainder = target - array[i];
			
			if (canSum(target, array, memo) == true) {
				
				memo[target] = true;
				return true;
			}
			//System.out.println(remainder);
			
			
//			if (remainder < 0) {
//				
//			//	System.out.println("inside if ");
//				memo[target][array[i]] = false;
//			
//			} else {
//				memo[target] = true;
//				canSum(remainder, array, memo);
//			}
			
				
				
				
			
			
			
		}
		memo[target] = false;
		return false;
	}

	
}



/*
 public static boolean canSum(int target, int[] array, boolean[] memo) {
		
		if (target == 0) {
			
			return true;
		}
		
		if (target < 0) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			int remainder = target - array[i];
			
			if (canSum(remainder, array, memo)) {
				return true;
			}
			
			
		}
		
		return false;
	}
 */
