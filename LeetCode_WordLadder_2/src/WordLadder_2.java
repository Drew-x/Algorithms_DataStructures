import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_2  {
	
	static class  HelperNode {
		
		String value = null;
		
		HashSet<String> comBo = new HashSet<>();
		
		
		public HelperNode(String word) {
			
			this.value = word;
			
		}
		
		
		@Override
		public String toString() {
			return comBo.toString();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = {"hit","hot","dot","dog","lot","log","cog"};
		HashMap<String, HelperNode> map = new HashMap<>();
		HashMap<String , Set<String>> inverse = new HashMap<String, Set<String>>();
		
		for (int i = 0; i < wordList.length; i++) {
			
			String word = wordList[i];
			char[] letters = word.toCharArray();
			HelperNode hNode = new HelperNode(word);
			//
			Set<String> helperSet = new HashSet<String>();
			for (int j = 0; j < letters.length; j++) {
				char curr = letters[j];
				char wild = '*';
				
				letters[j] = wild;
				String tmp = String.valueOf(letters); // IMPORTANT line
				hNode.comBo.add(tmp);
				helperSet.add(word);

				letters[j] = curr;
			}// end inner
			
			
			map.put(word, hNode);
		}// end loop
		
		System.out.println(map.toString());
		System.out.println("INVERSE: "+inverse.toString());
		
		Set<String>keys =inverse.keySet();
		
		System.out.println(inverse.get("hi*"));
	}// main

	public static int findEndword(String startWord, String endWord, HashMap<String, HelperNode> map) {
		Queue<HelperNode> queue = new LinkedList<>();
		int count = 0;
		
		queue.add(map.get(startWord));
		HashSet<String> visited = new HashSet<String>();
		
		while (!queue.isEmpty()) {
			HelperNode current = queue.poll();
			if (current.value == endWord) {
				return count;
			}
			if (visited.contains(current.value)) {
				
			}
			
		}
	
		return -1;
	}
}
