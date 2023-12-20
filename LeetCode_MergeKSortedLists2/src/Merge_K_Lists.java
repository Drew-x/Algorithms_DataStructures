import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Merge_K_Lists {

	static class Node  implements Comparable<Node>{
		
		Integer pos = null;
		Integer value = null;
		
		int pointX = 0;
		public Node(Integer pos , Integer value) {
			// TODO Auto-generated constructor stub
			this.pos = pos;
			this.value = value;
			
			
		}
		
		@Override
		public String toString() {
			
			return "("+pos.toString()+","+ value.toString()+")" ;
		}

		@Override
		public int compareTo(Merge_K_Lists.Node otherNode) {
			// TODO Auto-generated method stub
			
			if (this.value > otherNode.value) {
				
				return 1;
			}else if (this.value < otherNode.value) {
				return -1;
			}else {
				return 0;
			}
			
		}

		

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] lists = {{ 1,4,5},{1,3,4},{2,6},{0}};
		//Node node = new Node( lists.length , lists[0][0]);
		
		HashMap<Integer, Deque<Node>> map = new HashMap<Integer, Deque<Node>>();
		
		
		System.out.println(""+lists[0][0]);
		
		for (int i = 0; i < lists.length; i++) {
			
			Deque<Node> queue = new LinkedList<Node>();
			
			for (int j = 0; j < lists[i].length; j++) {
				Node node = new Node(i, lists[i][j]);
				queue.add(node);
			}// end inner 
			map.put(i, queue);
		}// end for 
		System.out.println(map.toString());
		
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
		
		Set<Integer> sets = map.keySet();
		
		for (Integer index : sets) {
			Node a = map.get(index).pollFirst();
			//System.out.println("INDEX: "+ index);
			a.pointX = index;
//			if (map.get(index).isEmpty()) {
//				//System.out.println("here");
//				map.remove(index);
//			}
			minHeap.add(a);
		}
		
		ArrayList<Integer> sol = new ArrayList<>();
		int index = 0;
		
		while(!sets.isEmpty()) {
			
			
			if (minHeap.poll() != null) {
				Node pollNode = minHeap.poll();
				if (map.get(pollNode.pointX ) != null) {
					
					minHeap.add(map.get(pollNode.pointX).pollFirst());
					sol.add(pollNode.value);
					
					
				}
				
			}
				
			
			
			
		}
		System.out.println("out loop");
		System.out.println(sol.toString());
//		System.out.println("MIN: "+ minHeap.toString());
//		minHeap.poll();
//		System.out.println("MIN: "+ minHeap.toString());
//		
//		System.out.println("Map: "+ map.toString());
	}

}
