package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class partition {
	
    public static List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>(); 
    	List<String> tmp = new ArrayList<String>();
    	dfs(res, s, tmp);
    	return res;
    }
    
    private static void dfs(List<List<String>> res, String s, List<String> tmp){
    	if(s.length()==0){
    		res.add(new ArrayList<String>(tmp));
    		return;
    	}
    	for(int i=0; i<s.length(); i++){
    		if(isPalin(s.substring(0, i+1))){
    			tmp.add(s.substring(0, i+1));
    			dfs(res, s.substring(i+1), tmp);
    			tmp.remove(tmp.size()-1);
    		}
    	}
    }
    
    private static boolean isPalin(String s){
    	for(int i=0; i<s.length()/2; i++){
    		if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("a"));
	}

}
