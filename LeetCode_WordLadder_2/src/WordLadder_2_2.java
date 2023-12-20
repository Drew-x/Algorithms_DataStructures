import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] wordList = {"hit","hot","dot","dog","lot","log","cog"};
		
		HashMap<String, HashSet<String>> map = new HashMap<>();
		HashMap<String, HashSet<String>> inverse = new HashMap<>();
		
		
		for(int i =0; i < wordList.length; i++) {// get words from string[]
			
			String word = wordList[i];
			char[] letters = word.toCharArray();
			HashSet<String> tset = new HashSet<String>();
			for (int j = 0; j < letters.length; j++) {// create patterns
				char wild ='*';
				char current =letters[j];
				letters[j] = wild; // swap
				String tempWord = String.valueOf(letters);
				tset.add(tempWord);
				inverse.put(word, tset);
				
				// condition not exist 
				if (!inverse.containsKey(tempWord)) {
					if(inverse.get(tempWord) == null) {
						HashSet<String> tempSet = new HashSet<String>();
						tempSet.add(word);
						inverse.put(tempWord, tempSet);
					}
				}// end not exist 
				
				
				//Condition exist
				if (inverse.containsKey(tempWord)) {
					HashSet<String> tempSet = inverse.get(tempWord); // get existing set and add new word
					tempSet.add(word);
					
					inverse.put(tempWord, tempSet);
					
				}// end if exisit
				
				letters[j] = current; // swap current letter back 
			}
			
			HashSet<String> visited = new HashSet<>();
			breath(inverse, visited,"hit");
			
		}// end for loop
		
	System.out.println(inverse.toString());
		
	}// end main
	
	
	public static void breath(HashMap<String, HashSet<String>> map, HashSet<String> visitied, String start  ) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		
		
		while (!queue.isEmpty()) {
			String current = queue.poll();
			System.out.println(current);
			
			for (String currItem : map.get(current)) {
				if (!visitied.contains(currItem)) {
					System.out.println(currItem);
					visitied.add(currItem);
					queue.add(currItem);
				}
				
						
			}
			
		}
		
	}

}// end class
