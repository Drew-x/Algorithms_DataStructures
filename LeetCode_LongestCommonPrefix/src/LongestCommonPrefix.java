import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"flower","flow","flight"};
		HashMap<Integer, ArrayList<HashSet<Character>>> map = new HashMap<>();
		
		ArrayList<HashSet<Character>> aList = new ArrayList<>();
		HashSet<Character> cSet = new HashSet<>();
		for (int i = 0; i < strs.length; i++) {
			String word = strs[i];
			char[] letters = word.toCharArray();
			
			
			
			
			
			for (int j = 0; j < letters.length; j++) {
				
				cSet.add(letters[j]);
				aList.add(cSet);
			}
			map.put(i, new ArrayList<>(aList));
			aList.clear();
//			System.out.println("word:" + word);
//			System.out.println(letters);
			
			
		}
		
		
		System.out.println(map.toString());
		
	}

}
