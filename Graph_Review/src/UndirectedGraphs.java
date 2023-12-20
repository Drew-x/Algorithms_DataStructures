import java.util.*;

public class UndirectedGraphs {

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
		System.out.println(hasPathUndirected(myMap2, 'f','k', new HashSet<>()));
		
		HashMap<Integer, ArrayList<Integer>> myMap5 = new HashMap<>(); // Acyclic graph 
		//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
		myMap5.put(0, new ArrayList<Integer>(Arrays.asList(8,1,5,7,11,111))); // CHANGED for STACK implementation
		myMap5.put(1, new ArrayList<Integer>(Arrays.asList(0)));
		myMap5.put(5, new ArrayList<Integer>(Arrays.asList(0,8)));
		myMap5.put(8, new ArrayList<Integer>(Arrays.asList(0,5)));
		myMap5.put(2, new ArrayList<Integer>(Arrays.asList(3,4)));
		myMap5.put(3, new ArrayList<Integer>(Arrays.asList(2,4)));
		myMap5.put(4, new ArrayList<Integer>(Arrays.asList(3,2)));
		myMap5.put(7, new ArrayList<Integer>(Arrays.asList()));
		myMap5.put(11, new ArrayList<Integer>(Arrays.asList()));
		myMap5.put(111, new ArrayList<Integer>(Arrays.asList()));
		
		
		HashMap<Integer, ArrayList<Integer>> myMap4 = new HashMap<>(); // Acyclic graph 
		//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
		myMap4.put(3, new ArrayList<Integer>(Arrays.asList())); // CHANGED for STACK implementation
		myMap4.put(4, new ArrayList<Integer>(Arrays.asList(6 )));
		myMap4.put(6, new ArrayList<Integer>(Arrays.asList(4,5,7,8)));
		myMap4.put(8, new ArrayList<Integer>(Arrays.asList(6)));
		myMap4.put(7, new ArrayList<Integer>(Arrays.asList(6)));
		myMap4.put(5, new ArrayList<Integer>(Arrays.asList(6)));
		myMap4.put(1, new ArrayList<Integer>(Arrays.asList(2)));
		myMap4.put(2, new ArrayList<Integer>(Arrays.asList(1)));
		
		System.out.println(connectedComponents(myMap4));
		
	}
	
	public static int connectedComponents(HashMap<Integer, ArrayList<Integer>> map) {
		
		Set<Integer> set = map.keySet();
		HashSet<Integer> visited = new HashSet<>();
		
		int count = 0;
		
		for (Integer cNode : set) {
			if (helperConnectedComponets(map, visited, cNode)== true) {
				count++;
			}
			//helperConnectedComponets(map,visited, cNode );
		}
		
		return count;
	}
	public static boolean helperConnectedComponets(HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited , Integer start) {
		
		if (visited.contains(start)) {
			return false;
		}
		
		visited.add(start);
		
		for( Integer cNode : map.get(start)) {
			helperConnectedComponets(map, visited, cNode);
		}
		
		return true;
	}
	
	public static boolean hasPathUndirected(HashMap<Character, ArrayList<Character>> map, Character Start, Character des, HashSet<Character> visited) {
		
		Stack<Character> stack = new Stack<>();
		stack.add(Start);
		
		while (!stack.isEmpty()) {
			
			Character current = stack.pop();
			
			
			if (current.equals(des)) {
				return true;
			}
			
			if (visited.contains(current)) {
				return false;
			}
			
			for(Character cNode : map.get(current)) {
				stack.add(cNode);
			}
			
		}
		
		return false;
	}

}
