import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UndirectedHasPath {

public static boolean hasPath(HashMap<Character, ArrayList<Character>> list, Character source, Character destination, HashSet<Character> vistedSet ) {
		
		if (source == destination) {
			return true;
		}
		
		if (vistedSet.contains(source)) {
			return false;
		}
		
		vistedSet.add(source); // adding to visited
		
		for (Character cNode : list.get(source)) {
			if (hasPath(list, cNode, destination,vistedSet) == true) {
				return true; 
			}
		}
		
		return false;
		
	}
	
}

/*
		HashMap<Character, ArrayList<Character>> myMap3 = new HashMap<>(); // Acyclic graph 
		//myMap.put('a', new ArrayList<Character>(Arrays.asList('b','c')));
		myMap3.put('i', new ArrayList<Character>(Arrays.asList('j','k'))); // CHANGED for STACK implementation
		myMap3.put('j', new ArrayList<Character>(Arrays.asList('i' )));
		myMap3.put('k', new ArrayList<Character>(Arrays.asList('i','m','l')));
		myMap3.put('m', new ArrayList<Character>(Arrays.asList('k')));
		myMap3.put('l', new ArrayList<Character>(Arrays.asList('k')));
		myMap3.put('o', new ArrayList<Character>(Arrays.asList('n')));
		myMap3.put('n', new ArrayList<Character>(Arrays.asList('o')));
		
		
		
		System.out.println(myMap3.toString());
		System.out.println();
		HashSet<Character> set = new HashSet<>();
		System.out.println(UndirectedHasPath.hasPath(myMap3, 'j', 'm', set));
		
		*/
