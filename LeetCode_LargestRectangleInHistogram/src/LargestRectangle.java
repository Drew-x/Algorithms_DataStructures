import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangle {


	static class MyNode <T1, T2> {
		
		T1 index = null;
		T2 height = null;
		
		public MyNode(T1 pos, T2 height) {
			this.index = pos;
			this.height = height; 
		}

		@Override
		public String toString() {
			return "(" + index + "," + height+ ")" ;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Stack tester code 
		 * 	Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println(s.toString());
		s.pop();
		System.out.println(s.toString());
		System.out.println(s.peek());
		*/ 
		
		int largest = 0;
		
//		int[] heights = {2,1,5,6,2,3};
//		int[] heights = {1,3,2,1,2};
		
		int[] heights ={2,1,5,6,2,3};
		
		Deque<MyNode<Integer, Integer>> stack = new LinkedList<>();
	
		for (int i = 0; i < heights.length; i++) {
			MyNode<Integer, Integer> current = new MyNode<Integer, Integer>(i,heights[i]);			
			System.out.println("current"+ current);
			while (!stack.isEmpty() && current.height < stack.peekLast().height  ) {
				
//				System.out.println("ENTER: "+ stack.toString());
//				System.out.println("Current: "+ current);
				
				MyNode<Integer,Integer> prev = stack.pollLast();

				current.index = prev.index; // SAVE Previous index
				int temp = i;
				System.out.println("prev height "+ prev.height + "pre index" + prev.index);
				int size = prev.height * (temp - prev.index); // Size = ( previous height) * ( (current index)  - (previous Index)
				System.out.println("index: "+i + " size"+ size);
				if (size > largest) { // swaps largest 
					
					largest = size;
					System.out.println("LARGEST "+ largest);
				}// end if
				// check 
				
			}// end if 
			System.out.println(stack.toString());
			stack.add(current);
			
		}// end for loop
		//System.out.println("heights - "+ heights.length);
		System.out.println(stack.toString());
		while (!stack.isEmpty()) {
			
//			if (stack.peekLast().height == heights.length ) {
//				
//			}
			
			MyNode<Integer, Integer> current = stack.pollLast();
			int size = current.height * (heights.length - current.index); // Size = ( current height) * ( (array.Length )  - (current Index)
			System.out.println("index: " + " size"+ size);
			if (size > largest) {
				largest = size;
			}
			
		}
		
		//MyNode<Integer, Integer> a = stack.getFirst();
//		System.out.println(stack.toString());
//		stack.pollLast();
//		System.out.println(stack.toString());
//		System.out.println(stack.peekLast().toString());
		
		System.out.println("Largest "+ largest);
		
	}

}
