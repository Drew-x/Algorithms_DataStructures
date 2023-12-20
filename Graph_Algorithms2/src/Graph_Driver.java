import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Driver {

	public static class Node {
		
		Character value = (Character) null;
		Integer amount = 0;
		
		public Node (Character value, Integer amount) {
			this.value = value;
			this.amount = amount;
		}// en constr
		
	}// END node
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Start Shortest 
		HashMap<Character, ArrayList<Character>> myMap = new HashMap<>();
		myMap.put('w', new ArrayList<Character>(Arrays.asList('x','v'))); // CHANGED for STACK implementation
		myMap.put('x', new ArrayList<Character>(Arrays.asList('w','a' )));
		myMap.put('y', new ArrayList<Character>(Arrays.asList('x','z')));
		myMap.put('z', new ArrayList<Character>(Arrays.asList('y' )));
		myMap.put('a', new ArrayList<Character>(Arrays.asList( 'x','y')));
		myMap.put('v', new ArrayList<Character>(Arrays.asList( 'z','w')));
	
		System.out.println(myMap.toString());
		System.out.println(shortestPath(myMap, 'w', 'z'));
		// END shortest 
		
		
		
		// Start Island Count
		System.out.println("INLAND COUNT  \n");
		char[][] grid = {
		                   {'W', 'L', 'W', 'W', 'W'},
		                   {'W', 'L', 'W', 'W', 'W'},
							{'W', 'W', 'W', 'L', 'W'},
							{'W', 'W', 'L', 'L', 'W'},
							{'L', 'W', 'W', 'L', 'L'},
							{'L', 'L', 'W', 'W', 'W'},
		                   };
		HashSet<String> visited = new HashSet<>();
		
		System.out.println("CHEKCER: "+ grid[0].length);
		
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[i].length; j++) {
				
				System.out.print(" "+ grid[i][j] + " "+ "("+i +","+j+")");
				if (grid[i][j] == 'L') {
					
					if ( islandCount(grid, i, j, visited) == true ) {
						count += 1;
					}
					//islandCount(grid, i, j);
				}
			}
				System.out.println();
		}
		System.out.println("the total count is " + count);
		
		System.out.println(""+visited.toString());
		
		//END island Count 
		System.out.println("\n");
		System.out.println("Smallest Island");
		HashSet<String> visited2 = new HashSet<>();
		int smallest = -1;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//System.out.print(""+ grid[i][j]);
				int num = smallestIsland(grid, i, j, visited2);
				//System.out.println("THE NUM "+ num);
				if (smallest == -1 && num != 0) {
					smallest = num;
				}
				if (smallest > num && num !=0) {
					smallest = num;
				}
			}
			System.out.println();
		}
		
		System.out.println("The smallest Island is: "+ smallest);
		
	}// end main 
	
	public static int shortestPath(HashMap<Character, ArrayList<Character>> list, Character start, Character des) {
		
		Queue<Node> queue = new LinkedList<>();
		HashSet<Character> visitied = new HashSet<Character>();
		//Integer x = 0;
		
		Node node = new Node(start, 0);
		
		queue.add(node);
		
		
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			
			if (current.value == des) {
				
				return current.amount;
			}
			
			
			for (Character childNode : list.get(current.value)) {
				
				Node node2 = new Node(childNode, current.amount );
				
				if(!visitied.contains(node2.value)) {
					visitied.add(node2.value);
					queue.add(new Node(node2.value, node2.amount +=1));
				}// end if
				
				
				 
		}// end for
		
		
		
	}
		return -1 ;
		
}// end shortestPath


	
	
	public static boolean islandCount(char[][] grid, int row, int col , HashSet<String> visited) {
		
		if ( (row < 0 || row >= grid.length ) || (col < 0 || col >= grid[row].length ) ) {
			return false;
		}
		
		if(visited.contains(row+"-"+col )) {
			return false;
		}
		
		if (grid[row][col] =='W') {
			return false;
		}
		
		visited.add(row+"-"+col);
		
		islandCount(grid, row -1, col, visited);
		islandCount(grid, row +1 , col, visited);
		islandCount(grid, row , col -1, visited);
		islandCount(grid, row , col +1, visited);
		
		return true;
	}
	
	
	public static int smallestIsland(char[][] grid,int row, int col , HashSet<String> visited ) {
		
		if ( (row < 0 || row >= grid.length )|| (col < 0 || col >= grid[row].length)) {
			//System.out.println("IN1");
			return 0;
		}
		
		if (grid[row][col] =='W') {
			//System.out.println("IN2");
			return 0;
		}
		if (visited.contains(row+"-"+col)) {
			//System.out.println("IN3");
			return 0;
		}
		
		//System.out.println("IN4");
		visited.add(row+"-"+col);
		
		
		
//		if (grid[row][col] == 'L') {
//			count++;
//		}
		int count = 1;
		
		count += smallestIsland(grid, row -1, col, visited );
		count += smallestIsland(grid, row +1, col, visited);
		count += smallestIsland(grid, row , col - 1, visited);
		count += smallestIsland(grid, row , col + 1 , visited);
	
	//	System.out.println("COUNT"+count);
		
		return count ;
		
	}
	
	
}// end Grap
