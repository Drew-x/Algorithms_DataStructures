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
import java.util.Stack;

public class WordLadder3 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] listwords = {"hot","dot","dog","lot","log","cog"};
		List<String> list = Arrays.asList(listwords);
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		Stack<String> s = new Stack<>();
		
		PriorityQueue<Integer> p = new PriorityQueue<>();
		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		
		p.add(5);
		p.add(6);
		p.add(7);
		
		a.add(5);
		a.add(6);
		a.add(7);
		System.out.println(a.poll());
		
		for (int i = 0; i < listwords.length; i++) {
			String word = listwords[i];
			char[] letters = word.toCharArray();
			
			//ArrayList<String> a = new ArrayList<String>();
			for (int j = 0; j < letters.length; j++) {
				char wild ='*';
				char curr = letters[j];
				letters[j]= wild;
				String temp = String.valueOf(letters);
				//a.add(temp);
				//map.put(word,a );
				System.out.println(temp);
				letters[j] = curr;
				
				
			}
			
			
			
		}
	
		System.out.println("List "+list.toString());
		System.out.println("map: "+map);
		
		
	}

}
