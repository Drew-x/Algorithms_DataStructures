import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class WordLadder_2_1 {

	static class Hnode {
		String key = null;
		HashSet<String> patterns = null;
		public Hnode(String key, HashSet<String> patterns) {
			// TODO Auto-generated constructor stub
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordList = {"hit","hot","dot","dog","lot","log","cog"};
		
		HashMap<String,ArrayList<String>> map = new HashMap<>();
		HashMap<String,HashSet<String>> inverse = new HashMap<>();
		System.out.println(inverse);
		for (int i = 0; i < wordList.length;  i++) {//wordList.length;
			String word = wordList[i];
			char[] letters = word.toCharArray();
			
			ArrayList<String> list = new ArrayList<>(); // array here to add to map - changes to null
			HashSet<String> inverselist = new HashSet<>();
			
			
			for (int j = 0; j < letters.length; j++) {
				// swaps value and adds to list
				char wild ='*';
				char current = letters[j];
				letters[j] = wild; // swaps
				String text = String.valueOf(letters);
				list.add(text);
				//swaps value and adds to list
				
				
				//create map and key in values
				if (!inverse.containsKey(text)) {
					if(inverse.get(text) == null) {
						//System.out.println("NULL: "+ inverse.get(text) +" word text: "+ text);
						HashSet<String> t = new HashSet<>();
						t.add(word);
						inverse.put(text, t);
						
					}	
					
				}
				
				if(inverse.containsKey(text)) {
					HashSet<String> x = inverse.get(text);
					x.add(word);
					//System.out.println("ELSE: "+ inverse.get(text) +" word text: "+ text);
					inverse.put(text, x);
				}
//				inverselist.add(word);
//				inverse.put(text,inverselist);
				//inverse.put(text, new ArrayList(new String(word)));
				
				
				//create map and key in values
				
				
				//System.out.println(text);
				letters[j] = current; // change back PART OF 1
			}
			
			// Add into map 
			map.put(word,list);// finished map
			//inverse.put(word,null);
		}// creates the words to chars 
		
		System.out.println(map.toString());
		System.out.println("In-: "+ inverse.toString());
		//breadthForSeacrch(inverse, "hit", "cog");
/*		
		Set<String> keys = map.keySet();
		HashMap<String, String> fMap = new HashMap<>();
		for (String key : keys) {
			System.out.println("KEY: "+ key+ "  values: "+map.get(key));
			ArrayList<String> ppList = map.get(key);
			
			for(String val : ppList) {
				
				
			}
			
			
			
		}// end for
*/		
		
		//System.out.println(map.toString());
		//String s = "hit";
		System.out.println();
		//breadthForSeacrch(map, "hit", "cog");
		//System.out.println(list.toString()); // prints list
		

		
	}
	public static void breadthForSeacrch(HashMap<String, HashSet<String>> list, String source, String des) {
		
		Queue<String> queue = new LinkedList<>();
		HashSet<String> visitied = new HashSet<String>();
		//Integer x = 0;
		
		//Node node = new Node(start, 0);
		
		queue.add(source);
		
		
		while (!queue.isEmpty()) {
			String current = queue.remove();
			
			if (current == des) {
				System.out.println("true");
				//return true;
			}
			
			
			for (String childNode : list.get(current)) {
				
				String node2 = childNode;
				
				if(!visitied.contains(node2)) {
					visitied.add(node2);
					queue.add(node2);
				}// end if
				
				
		
	}

		
		}
		}
	}	
