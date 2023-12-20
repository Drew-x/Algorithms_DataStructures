import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Character, ArrayList<Character>> map = new HashMap<>();
		map.put('a', new ArrayList<Character>(Arrays.asList('c','b')));
		map.put('b', new ArrayList<Character>(Arrays.asList('d')));
		map.put('c', new ArrayList<Character>(Arrays.asList('e')));
		map.put('d', new ArrayList<Character>(Arrays.asList('f')));
		map.put('e', new ArrayList<Character>(Arrays.asList()));
		map.put('f', new ArrayList<Character>(Arrays.asList()));
		
	
		System.out.println(map.toString());
		//stackDepthFirst(map, 'a');
		//recursiveDepthFirst(map, 'a');
		breathFirstSearch(map,'a');
	}
	private static void breathFirstSearch(HashMap<Character, ArrayList<Character>> map , Character start) {
		Queue<Character> queue = new LinkedList<>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			
			Character current = queue.poll();
			System.out.println(current);
			
			for(Character cNode : map.get(current)) {
				queue.add(cNode);
			}
			
		}
		
	}
	
	public static void recursiveDepthFirst(HashMap<Character, ArrayList<Character>> map , Character start) {
		
		System.out.println(start);
		
		for(Character cNode : map.get(start)) {
			recursiveDepthFirst(map, cNode);
		}
	}
	
	public static void stackDepthFirst(HashMap<Character, ArrayList<Character>> map , Character start) {
		
		Stack<Character> stack = new Stack<>();
		
		stack.push(start);
		
		while (!stack.isEmpty()) {
			Character current = stack.pop();
			System.out.println(current);
			
			for(Character cNode : map.get(current)) {
				stack.push(cNode);
			}
			
		}
	}

}
