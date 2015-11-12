package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AllPalindrome {
	
	//Uber Phone
	
	public boolean isValid(String s){
		//at most one odd char
		int[] charcount = new int[255];
		for(int i=0; i<s.length(); i++){
			charcount[i]+=1;
		}
		int oddcount=0;
		for(int i=0; i<charcount.length; i++){
			if((charcount[i] & 1) ==1) oddcount++;
		}
		return oddcount>1 ? false : true;
	}
	
	//Generate prefix
	List<String> helper(Map<Character, Integer> map){
		List<String> res = new ArrayList<String>();
		
		if(map.size()==1){
			int n=0;
			char c=0;
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				c=entry.getKey();
				n=entry.getValue()/2;
			}
			String s="";
			for(int i=0;i<n;i++) s+=c;
			res.add(s);
			return res;
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue()%2==0){
				int value=entry.getValue();
				if(value==2) map.remove(entry.getKey());
				else map.put(entry.getKey(), entry.getValue()-2);
				
				List<String> list=helper(map);
				for(String ss : list){
					res.add(entry.getKey()+ss);
				}
				if(value==2) map.put(entry.getKey(), 2);
				else map.put(entry.getKey(), entry.getValue()+2);
			}
		}
		return res;
	}
	
	
	public List<String> generatePalindrome(String s){
		Map<Character, Integer> map=new ConcurrentHashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}
			else{
				map.put(s.charAt(i),1);
			}
		}
		String center="";
		for(Map.Entry<Character, Integer> e : map.entrySet()){
			if(e.getValue()%2==1){
				center+=e.getKey();
				if(e.getValue()==1) map.remove(e.getKey());
				else map.put(e.getKey(), e.getValue()-1);
			}
		}
		List<String> list=helper(map);
		List<String> res=new ArrayList<String>();
		for(String ss : list){
			res.add(ss+center+new StringBuilder(ss).reverse());
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPalindrome a=new AllPalindrome();
		System.out.println(a.generatePalindrome("abababb"));
	}

}
