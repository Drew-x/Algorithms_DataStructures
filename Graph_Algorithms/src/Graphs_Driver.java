import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Graphs_Driver {


	/*
	 * //	int[] x = {1,2,3,4};

//	for (int i : x) {
//		System.out.println(i);
//	}
//	
	 */
	public class Node {
		
		Character value = null;
		Integer amount = null;
		
		public Node (Character value, Integer amount) {
			this.value = value;
			this.amount = amount;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
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
		

		//System.out.println(myMap4.toString());
		
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
		
		System.out.println(myMap5.toString());
		
		System.out.println(largestComponent(myMap5));
		
		System.out.println("\n \nShortest path");
		
		HashMap<Character, ArrayList<Character>> myMap = new HashMap<>();
		myMap.put('w', new ArrayList<Character>(Arrays.asList('x','v'))); // CHANGED for STACK implementation
		myMap.put('x', new ArrayList<Character>(Arrays.asList('w','y' )));
		myMap.put('y', new ArrayList<Character>(Arrays.asList('x','z')));
		myMap.put('z', new ArrayList<Character>(Arrays.asList('y','v' )));
		myMap.put('v', new ArrayList<Character>(Arrays.asList( 'z','w')));
	
		System.out.println(myMap.toString());
		
		
		System.out.println(shortestPath(myMap,'w','z'));
	}
	
	/*	PREVIOUS code
	 * 			//connectedComponents(myMap4,6);
	
		connectedComponentCount(myMap4);
		
		//HashSet<Character> set = new HashSet<>();
	//	System.out.println(UndirectedHasPath.hasPath(myMap3, 'j', 'm', set));
		
//		System.out.println( HasPath.depthForSearchRecursive(myMap3, 'f', 'k')); //HAS PATH
//		
//		System.out.println(HasPath.depthForSearchStack(myMap3, 'i', 'k'));  //HAS PATH
		
		//depthFirstSearch(myMap, 'a'); //PASS
//		System.out.println("Starting Depth first search ");
//		GraphTraversal.depthFirstSearchRecursive(myMap, 'a');
		
//		System.out.println("Starting Breadth for search ");
//		GraphTraversal.breadthForSeacrch(myMap, 'a');
		
		//HashMap<Character,ArrayList< Character>> myMap3 = new HashMap<>();
		char[] test = {'h','e','l','l','o'};
		//myMap2.put('o', new ArrayList<Character>(Arrays.asList('h','e','l','l','o')) );
		
		//System.out.println(myMap.values());
	 */
	
	public static void connectedComponents(HashMap<Integer, ArrayList<Integer>> list) {
		
		Stack<Integer> stack = new Stack<>();
		
		Set<Integer> set = list.keySet();
		HashSet<Integer> visitedList = new HashSet<Integer>();
		
		for (Integer cNode : set) {
			stack.add(cNode);
		}
		
		
		while (!stack.empty() ) {
			
			Integer current = stack.pop();
			//System.out.println(current);
			
			for (Integer cNode : list.get(current)) {
				//System.out.println(integer);
//				if (visitedList.contains(cNode) ) {
//					break;
//				}
				visitedList.add(current);
				System.out.println(cNode);
				
			}
			

		}
		
		

		
//		for (Integer object : set) {
//			//System.out.println(object);
//			stack.add(object);
//			
//		}
		
	}
	
	// Connected component 
	public static void connectedComponentCount(HashMap<Integer, ArrayList<Integer>> list) {
		Stack<Integer> stack = new Stack<>();
		
		Set<Integer> set = list.keySet();
		HashSet<Integer> visitedList = new HashSet<Integer>();
		int count = 0;
		for (Integer cNode : set) {
			System.out.println("FIRST CALL key- "+cNode);
			if (explore(list, cNode, visitedList) == true) {
				count+=1;
				System.out.println("COUNT - "+ count);
			}
			
		}
		
		System.out.println("The count is: "+count);
	}// connected componented  
	
	public static boolean explore(HashMap<Integer, ArrayList<Integer>> list, Integer current, HashSet<Integer> visitedSet) {
		
		if (visitedSet.contains(current)) {
			System.out.println("HIT FALSE");
			return false;
		}
		
		visitedSet.add(current);
		System.out.println("TOP- "+current);
		for (Integer cNode : list.get(current)) {
			System.out.println("INSIDE LOOP- "+ cNode);
			explore(list, cNode, visitedSet);
		}
		return true;
	}
	
	// END Connected component 
	
	// Largest component 
	public static int largestComponent(HashMap<Integer, ArrayList<Integer>> list) {
		
		int currentLargest = 0;
		Set<Integer> keys = list.keySet();
		
		HashSet<Integer> visited = new HashSet<>();
		
		for (Integer cNode : keys) {
			
//			if (largestComponentExplore(list, cNode, visited) > currentLargest) {
//				currentLargest = largestComponentExplore(list, cNode, visited);
//			}
			
			int size = exploreLongest(list, cNode, visited);
			
			if (currentLargest < size) {
				currentLargest =size;
			}
			
		}
		
		
		return currentLargest;
		
	}
	
	public static int exploreLongest(HashMap<Integer, ArrayList<Integer>> list, int cNode, HashSet<Integer> visitedSet) {
		
		
		if (visitedSet.contains(cNode)) {
			return 0;
		}
		
		visitedSet.add(cNode);
		int count = 1;
		
		for (Integer childNode : list.get(cNode)) {
			
			count += exploreLongest(list, childNode, visitedSet);
				
			
		}
		
		
		return count;
	}
	
	// END Largest component 
	
	
	public static int shortestPath(HashMap<Character, ArrayList<Character>> list, Character source, Character destination) {
		Set<Character> keys = list.keySet();
		HashSet<Character> visited = new HashSet<>();
		
		
		Queue<Node> queue = new LinkedList<>();
		int shortest = -1;
		for (Character cNode : keys) {
			
			int checker = exploreShortestPath(list, cNode , visited, destination, shortest);
			if (shortest == -1) {
				shortest = checker;
			}
			
			if (shortest > checker) {
				
				shortest  = checker;
			}
			
		}
		
		
		return shortest;
		
	}
	
	public static int  exploreShortestPath(HashMap<Character, ArrayList<Character>> list, Character source, HashSet<Character> visited, Character des, int count) {
		
		if (visited.contains(source)) {
			return 0;
		}
		
		
		visited.add(source);
		
		
		if (source == des) {
			return count;
		}
		
		
		int num = 1;
		
		for (Character character : visited) {
			
			num += exploreShortestPath(list, character, visited, des, num);
			
		}
		
		return num;
	}
	
}// end graph driver 
//oxandrolone