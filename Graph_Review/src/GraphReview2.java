import java.util.*;
public class GraphReview2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Character, ArrayList<Character>> myMap2 = new HashMap<>(); // Acyclic graph 
		//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
		myMap2.put('f', new ArrayList<Character>(Arrays.asList('g','i'))); // CHANGED for STACK implementation
		myMap2.put('g', new ArrayList<Character>(Arrays.asList('h' )));
		myMap2.put('h', new ArrayList<Character>(Arrays.asList()));
		myMap2.put('i', new ArrayList<Character>(Arrays.asList('g','k' )));
		myMap2.put('j', new ArrayList<Character>(Arrays.asList( 'i')));
		myMap2.put('k', new ArrayList<Character>(Arrays.asList( )));
		
		 System.out.println(hasPathBreath(myMap2, 'f', 'k'));
	    System.out.println(hasPath(myMap2, 'f', 'k'));
		
		
	}// end main
	
	public static Boolean hasPathBreath(HashMap<Character, ArrayList<Character>> map, Character start, Character des) {
		
		Queue<Character> queue = new LinkedList<>();
		queue.add(start);
		boolean checker = false;
		while (!queue.isEmpty() || checker == true) {
			
			Character current = queue.poll();
			System.out.println(current);
			if (current.equals(des)) {
				return true;
			}
			
			for(Character cNode : map.get(current)) {
				
				hasPathBreath(map, cNode, des);
			}
			
		}// inner loop
		
	
		return checker;
	}// end has
	
	public static boolean hasPath(HashMap<Character, ArrayList<Character>> map, Character start, Character des) {
		
		if (start.equals(des)) {
			return true;
			
		}// end if
		
		
		for(Character cNode : map.get(start)) {
			if (hasPath(map, cNode, des) == true) {
				return true;
			}
			
		}// end loop
		
		return false;
	}

	
}// end class
