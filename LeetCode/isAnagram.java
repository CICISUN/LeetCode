package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class isAnagram {
	
    public static boolean isAnagram(String s, String t) {
    	s.toLowerCase();
    	t.toLowerCase();
    	if(s.length()!=t.length()) return false;
    	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
    	for(int i=0; i<s.length();i++){
    		if(!map.containsKey(s.charAt(i))){
    			map.put(s.charAt(i), 1);
    		}
    		else map.put(s.charAt(i), map.get(s.charAt(i))+1);
    	}
    	for(int i=0;i<t.length();i++){
    		if(map.containsKey(t.charAt(i))){
    			if(map.get(t.charAt(i))>=1){
    				map.put(t.charAt(i), map.get(t.charAt(i))-1);
    			}
    			else return false;
    		}
    		else if(!map.containsKey(t.charAt(i))) return false;
    	}
    	return true;  	
    }
    
    public boolean isAnagramSort(String s, String t) {
        if (s == null || t == null) {
            return (s == null && t == null) ? true : false;
        }
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());

        return  new String(s1).equals(new String(t1)) ? true : false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("aabc","caba"));
	}

}
