import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Merge_K_Lists {

	static class HelperNode<T,Y>{
		
		T key = null;
		Y value = null;
	
		
		public HelperNode(T key, Y value) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] lists = {{ 1,4,5},{1,3,4},{2,6},{0}};
		
		System.out.println(lists.length);
		
		LinkedList<LinkedList<Integer>> items = new LinkedList<>();
		//HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		
		
		HashMap<Integer, Deque<Integer>> map = new HashMap<Integer, Deque<Integer>>();
		
		List z = Arrays.asList(lists[0].toString());
		
		System.out.println(""+lists[0][0]);
		
		for (int i = 0; i < lists.length; i++) {
			
			Deque<Integer> queue = new LinkedList<Integer>();
			map.put(i, null);
			for (int j = 0; j < lists[i].length; j++) {
				queue.add(lists[i][j]);
			}// end inner 
			map.put(i, queue);
		}// end for 
		System.out.println("map");
		System.out.println(map.toString());
		System.out.println("---");
		PriorityQueue<HelperNode<Integer, Integer>> heap = new PriorityQueue<>();
		
		mergeK(map, null, heap);
		
	}// end main 
	
	
	
	public static int[] mergeK(HashMap<Integer, Deque<Integer>> map, int[] sol, PriorityQueue<HelperNode<Integer, Integer>> heap) {
		
		Set<Integer> lists = map.keySet();
		
		for (Integer items : lists) {
			
			Deque<Integer> currList = map.get(items);
			HelperNode<Integer,Integer> helperNode = new HelperNode(items, currList.pollFirst());
								
			heap.add(helperNode);
		}
		
		
		System.out.println(heap.toString());
		
		heap.poll();
		System.out.println(heap.toString());
		
		System.out.println("map: "+map.toString());
		return null;
	}

}
