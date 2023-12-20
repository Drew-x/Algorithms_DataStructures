import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Merge_K_List3 {

	// Solutinos
	static class HelperNode implements Comparable<HelperNode>{
		
		LinkedList<Integer> list = null;
		Integer value = null;
		Integer key = null;
			
		public HelperNode(Integer key, LinkedList<Integer> list) {
			
			this.key = key;
			this.list = list;
			
		}

		@Override
		public String toString() {
			return "" + list.toString();
		}

		
		@Override
		public int compareTo(HelperNode o) {
			
			if (this.list.getFirst() < o.list.getFirst()) {
				return -1;
			}else if (this.list.getFirst() > o.list.getFirst()) {
				return 1;
			}else {
				return 0;
			}
			
			
			
		}
		

		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] lists = {{1,4,5},{1,3,4},{2,6},{0}};
		HashMap<Integer, HelperNode> map = new HashMap<Integer, HelperNode>();
		
		for (int i = 0; i < lists.length; i++) {
			
			LinkedList<Integer> temp = new LinkedList<Integer>();
			//Integer num = null;
			for (int j = 0; j < lists[i].length; j++) {
				
				temp.add(lists[i][j]);
				//num = lists[i][j];
			}
			HelperNode node = new HelperNode(i, temp);
			map.put(i,node);
		}
		System.out.println(map.toString());
		
		
		PriorityQueue<HelperNode> heap = new PriorityQueue<HelperNode>();
		
		int i =0;
		while (i < lists.length) {
			HelperNode node = map.get(i);
			
			System.out.println(node);
			heap.add(node);
			//node.list.removeFirst();
			i++;
		}
		
		//System.out.println("POLL "+heap.poll());
		System.out.println("HEAP "+ heap.toString());
		ArrayList<Integer> sol = new ArrayList<Integer>();
		while (!heap.isEmpty()) {
			HelperNode min = heap.poll();
			//System.out.println("MIN: "+ min);
			Integer minNum = min.list.pollFirst();	
			sol.add(minNum);
			System.out.println("INS: "+ heap.toString());
			
			if (min.list.size() != 0) {
				heap.add(min);
			}
			
			
			
			
		}
		
		System.out.println("OUT"+sol.toString());
		//heap.add(Collections.));
		//System.out.println( map.get(i));
		//System.out.println(heap.addAll(map.get(i)));
		//System.out.println(heap.poll());
		
	}
	
	
	public static  LinkedList<Integer> mergeKLists(LinkedList<Integer> lists) {
        
	       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
	        
	       return null;
	    }
}
