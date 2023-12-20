import java.util.Deque;
import java.util.LinkedList;

public class LongestPalindrom {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "babad";
		char[] letter = s.toCharArray();
        
        Deque<Character> deque = new LinkedList<>();
        Deque<Character> deque2 = new LinkedList<>();
        
        for(char l : letter){
            deque.add(l);
            deque2.push(l);
        }
        String q = helper(deque,deque2);
        
        char[] x = q.toCharArray();
        String sol = "";
        for(int i = 0; i< q.length(); i++){
        	System.out.println(x[i]);
            sol+=x[i]; 
        }
      System.out.println(sol);
		
	}// end main

	public static String helper(Deque<Character> deque,Deque<Character> deque2 ){
       String text1 = explore1(deque,deque2);
       String text2 = explore2(deque,deque2);
       String text3 = explore3(deque,deque2);
       
       if (text1.length() > text2.length() && text1.length() > text3.length()) {
    	   System.out.println("if 1 ");
    	   System.out.println(text1);
    	   return text1;
       }
       
       if (text2.length() > text1.length() && text2.length() > text3.length()) {
    	   System.out.println("if 2 ");
    	   System.out.println(text2);
   		return text2;
       }
       
       System.out.println("if 3 ");
       System.out.println(text3);
        return text3;
    }
    public static String explore1(Deque<Character> x,Deque<Character> y){
    	Deque<Character> deque = new LinkedList<Character>(x);
    	Deque<Character> deque2 = new LinkedList<Character>(y);
    	
    	if (deque.size() ==0) {
			return "";
		}
        if(deque.equals( deque2)){
        	//System.out.println(deque.toString());
        	String sol = "";
        	while (!deque.isEmpty()) {
        		sol += deque.poll();
			}
				
			
            return sol;
        }
        deque.pollFirst();
        deque2.pollFirst();
        
        
        return explore1(deque, deque2);
    }
    
     public static String explore2(Deque<Character> x,Deque<Character> y){
        
    	Deque<Character> deque = new LinkedList<Character>(x);
     	Deque<Character> deque2 = new LinkedList<Character>(y);
       
     	if (deque.size() ==0) {
			return "";
		}
     	if(deque.equals( deque2)){
     		String sol = "";
        	while (!deque.isEmpty()) {
        		sol += deque.poll();
			}
				
			
            return sol;
        }
        deque.pollLast();
        deque2.pollLast();
        explore2(deque, deque2);
        
        return explore2(deque, deque2);
    }
    
     public static String explore3(Deque<Character> x,Deque<Character> y){
    	
    	Deque<Character> deque = new LinkedList<Character>(x);
     	Deque<Character> deque2 = new LinkedList<Character>(y);
     	
     	if (deque.size() ==0) {
			return "";
		}
        if(deque.equals( deque2)){
        	String sol = "";
        	while (!deque.isEmpty()) {
        		sol += deque.poll();
			}
				
			
            return sol;
        }
         deque.pollLast();
         deque.pollFirst();
        
         deque2.pollLast();
         deque2.pollFirst();
         
        
        return explore3(deque, deque2);
    }
	
}
