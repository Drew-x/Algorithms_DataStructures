import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

public static void breadthForSeacrch(HashMap<Character, ArrayList<Character>> list, Character source) {
		
		Queue<Character> queue = new LinkedList<Character>();
		queue.add(source);
		
		while (!queue.isEmpty()) {
			Character currentNode = queue.remove();
			System.out.println(currentNode);
			
			for (Character childrenNodes : list.get(currentNode)) {
				queue.add(childrenNodes);
				
			}
		}
	}

	public static void depthFirstSearchRecursive(HashMap<Character, ArrayList<Character>> list, Character source) {
		System.out.println(source);
		for (Character character: list.get(source)) {
			depthFirstSearchRecursive(list, character);
		}
	}
	
	public static void depthFirstSearch(HashMap<Character, ArrayList<Character>> list, Character source ) {
		
		//Object node = list.get(source);
		
		Stack<Character> stack = new Stack<Character>();
		stack.add(source);
		
		while (!stack.empty()) {
			
			Character current = stack.pop();
			System.out.println(current);
			
			//ArrayList<Character> x = list.get(current);
			
			for (Character character : list.get(current)) {
				stack.add(character);
			}
			
		}// end while 
		//System.out.println(node.toString());
		
	}
	
	
}

/* PASTE into main 

HashMap<Character, ArrayList<Character>> myMap = new HashMap<>();

myMap.put('a', new ArrayList<Character>(Arrays.asList('c','b'))); // CHANGED for STACK implementation
//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
myMap.put('b', new ArrayList<Character>(Arrays.asList('d' )));
myMap.put('c', new ArrayList<Character>(Arrays.asList('e')));
myMap.put('d', new ArrayList<Character>(Arrays.asList('f' )));
myMap.put('e', new ArrayList<Character>(Arrays.asList( )));
myMap.put('f', new ArrayList<Character>(Arrays.asList( )));



*/
