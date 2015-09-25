package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
	
	 public static List<String> wordBreak(String s, Set<String> wordDict) {
	        List<String> res = new ArrayList<String>();
	        boolean[] cancut = new boolean[s.length()];
	        for(int i=0;i<s.length();i++){
	            if(wordDict.contains(s.substring(0,i+1))){
	                cancut[i]=true;
	                continue;
	            }
	            for(int j=0;j<=i;j++){
	                if(wordDict.contains(s.substring(j, i+1)) && cancut[j-1]){
	                    cancut[i]=true;
	                }
	            }
	        }
	        if(!cancut[s.length()-1]) return res;
	        dfs(wordDict, res, new ArrayList<String>(), s, 0);
	        return res;
	    }
	    
	    private static void dfs(Set<String> dict, List<String> res, List<String> tmp, String s, int start){
	        for(int i=start; i<s.length(); i++){
	            String cur = s.substring(start, i+1);
	            if(dict.contains(cur)){
	                tmp.add(cur);
	                if(i==(s.length()-1)){
	                    String each="";
	                    for(String word : tmp){
	                    	each= each +" " +word;
	                    }
	                    res.add(each.trim());
	                    
	                }
	                else{
	                    dfs(dict, res, tmp, s, i+1);
	                }
	                tmp.remove(tmp.size()-1);
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> a = new HashSet<String>();
		a.add("cat");
		a.add("cats");
		a.add("and");
		a.add("sand");
		a.add("dog");
		System.out.println(wordBreak("catsanddog", a));
	}

}
