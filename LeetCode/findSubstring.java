package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;


public class findSubstring {
	
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        HashMap<String, Integer> rest=new  HashMap<String, Integer>();
        HashMap<String, Integer> found=new  HashMap<String, Integer>();
        if(S==null||L.length==0) return res;
        int wordlen=L[0].length(), Llen=L.length, Slen=S.length();
        for(int i = 0; i<L.length;i++){
            int num=1;
            if(rest.get(L[i])!=null) 
            	num+=rest.get(L[i]);
            rest.put(L[i], num);
        }
       
        for(int i=0; i<Slen-Llen*wordlen+1;i++){
        	int j=0;
        	found.clear();
        	for(;j<Llen;j++){
        		int start=i+j*wordlen;
        		int end=start+wordlen;
        		int num=1;
        		String tmp=S.substring(start, end);
        		if(!rest.containsKey(tmp)) break;
        		if(found.get(tmp)!=null) num+=found.get(tmp);
        		if(num>rest.get(tmp)) break;
        		found.put(tmp, num);
        	}
        	if(j==Llen) res.add(i);
        }
        return res;   
    }
	
	public static ArrayList<Integer> findSubstring2(String S, String[] L) { 
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null||L==null||S.length()==0||L.length==0)
           return res;
        int wordLen = L[0].length();//same length for each word in dictionary
        
        //put given dictionary into hashmap with each word's count
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String word: L){
            if(!dict.containsKey(word))
               dict.put(word, 1);
            else
               dict.put(word, dict.get(word) + 1);
        }
        
        for(int i = 0; i < wordLen; i++){
            int count = 0;
            int index = i;//index of each startpoint
            HashMap<String, Integer> curdict = new HashMap<String, Integer>();
            //till the first letter of last word 
            for(int j = i; j <= S.length() - wordLen; j += wordLen){
                String curWord = S.substring(j, j + wordLen);
                //check each word to tell if it existes in give dictionary
                if(!dict.containsKey(curWord)){
                    curdict.clear();
                    count = 0;
                    index = j + wordLen;
                }else{
                    //form current dictionary
                    if(!curdict.containsKey(curWord))
                       curdict.put(curWord, 1);
                    else
                       curdict.put(curWord, curdict.get(curWord) + 1);
                    
                    //count for current found word and check if it exceed given word count
                    if(curdict.get(curWord) <= dict.get(curWord)){
                        count++;
                    }else{
                        while(curdict.get(curWord) > dict.get(curWord)){
                            String temp = S.substring(index, index + wordLen);
                            curdict.put(temp, curdict.get(temp)-1);
                            index = index + wordLen;//make index move next
                       if(curdict.get(temp)<dict.get(temp))
                            
                            
                            count--;
                        System.out.println(" -- "+count);
                        }
                    }
                    
                    //put into res and move index point to nextword 
                    //and update current dictionary as well as count num
                    if(count == L.length){
                        res.add(index);
                        System.out.println(count);
                        String temp = S.substring(index, index + wordLen);
                        curdict.put(temp, curdict.get(temp)-1);
                        index = index + wordLen;
                        count--;
                    }
                    System.out.println(" i "+ i+" j "+j+" curword "+curWord+" curict "+curdict+" index "+index+" count "+count);
                }
            }//end for j
        }//end for i
         return res;
       } 

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findSubstring f=new findSubstring();
		String[] L={"a","a","b","b","c"};
		System.out.println(f.findSubstring2("aaabbbc", L));
		
	}

}
