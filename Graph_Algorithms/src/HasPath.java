import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class HasPath {

	
public static boolean depthForSearchStack(HashMap<Character, ArrayList<Character>> list, Character source, Character destination) {
		
		Stack<Character> stack = new Stack<>();
		stack.add(source);
		
		while (!stack.isEmpty()) {
			
			Character currentItem = stack.pop();
			
			if (currentItem == destination) {
				return true;
			}
			
			for (Character cNode : list.get(currentItem)) {
				stack.add(cNode);
			}
			
		}
		
		return false;
	}
	
	public static boolean depthForSearchRecursive(HashMap<Character, ArrayList<Character>> list, Character source, Character destination) {
		
		if (source == destination) {
			
			return true;
		}
		
		for (Character itemChild : list.get(source)) {
			if (depthForSearchRecursive(list, itemChild, destination) == true) {
				return true;
			}
			
		}
		
		return false;
	}
	
	
}



/* PASTE INTO MAIN
 		HashMap<Character, ArrayList<Character>> myMap2 = new HashMap<>(); // Acyclic graph 
		//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
		myMap2.put('f', new ArrayList<Character>(Arrays.asList('g','i'))); // CHANGED for STACK implementation
		myMap2.put('g', new ArrayList<Character>(Arrays.asList('h' )));
		myMap2.put('h', new ArrayList<Character>(Arrays.asList()));
		myMap2.put('i', new ArrayList<Character>(Arrays.asList('g','k' )));
		myMap2.put('j', new ArrayList<Character>(Arrays.asList( 'i')));
		myMap2.put('k', new ArrayList<Character>(Arrays.asList( )));
		
		
		System.out.println( HasPath.depthForSearchRecursive(myMap2, 'f', 'k'));
		
		System.out.println(HasPath.depthForSearchStack(myMap2, 'i', 'k'));
 
 */










