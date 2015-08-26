import java.util.HashMap;


public class minWindow {

	public String minWindow(String S, String T) {
		if(S==null || S.length()==0)
			return "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<T.length();i++)
		{
			if(map.containsKey(T.charAt(i)))
			{
				map.put(T.charAt(i),map.get(T.charAt(i))+1);
			}
			else
			{
				map.put(T.charAt(i),1);
			}
		}
		int left = 0;
		int count = 0;
		int minLen = S.length()+1;
		int minStart = 0;
		for(int right=0; right<S.length();right++)
		{	System.out.println(" left "+ left+" right "+right+" map "+map+" word "+S.charAt(right)+" count "+count);
        
			if(map.containsKey(S.charAt(right)))
			{
				map.put(S.charAt(right),map.get(S.charAt(right))-1);
				if(map.get(S.charAt(right))>=0)
				{
					count++;
				}
				System.out.println(count+"map"+map);
				while(count == T.length())
				{
					if(right-left+1<minLen)
					{
						minLen = right-left+1;
						minStart = left;                    
					}
					if(map.containsKey(S.charAt(left)))
					{
						map.put(S.charAt(left), map.get(S.charAt(left))+1);
						if(map.get(S.charAt(left))>0)
						{
							count--;
						}
					}
					left++;
				}
			}
		}
		if(minLen>S.length())
		{
			return "";
		}
		return S.substring(minStart,minStart+minLen);
	}

	
	 public String minWindow2(String S, String T) {
		 if(S==null || S.length()==0)
				return "";
	        HashMap<Character,Integer> dict=new HashMap<Character,Integer>();
	        int tlen=T.length(), slen=S.length(),minlen=slen+1;
	        for (int i=0;i<tlen;i++){
	            int num=1;
	            if(dict.containsKey(T.charAt(i))) num+=dict.get(T.charAt(i));
	            dict.put(T.charAt(i),num);
	        }
	        int count=0,left=0,start=0;
	        for(int i=0;i<slen;i++){
	        	System.out.println(" left "+ left+" right "+i+" map "+dict+" word "+S.charAt(i)+" count "+count);
	            if(dict.containsKey(S.charAt(i))){
	                dict.put(S.charAt(i),dict.get(S.charAt(i))-1);
	                if(dict.get(S.charAt(i))>=0) count++;
	                if(count==tlen){
	                    while(count==tlen){
	                        if(i-left+1<minlen){minlen=i-left+1; start=left; }
	                        if(dict.containsKey(S.charAt(left))) {
	                             dict.put(S.charAt(left),dict.get(S.charAt(left))+1);
	                             if(dict.get(S.charAt(left))>0) count--;
	                        }
	                        left++;
	                    }
	                }
	            }
	        }
	        
	        return minlen>slen? "":S.substring(start,start+minlen);
	        
	    }
	 
	 
	 public String minWindow3(String S, String T) {
	     HashMap<Character, Integer> dict = new HashMap<>();
	     for (int i = 0; i < T.length(); i++) {
	         char c = T.charAt(i);
	         if (!dict.containsKey(c))
	             dict.put(c, 1);
	         else
	             dict.put(c, dict.get(c) + 1);
	     }
	     HashMap<Character, Integer> found = new HashMap<>();
	     int foundCounter = 0;
	     int start = 0;
	     int end = 0;
	     int min = Integer.MAX_VALUE;
	     String minWindow = "";
	     while (end < S.length()) {
	         char c = S.charAt(end);
	         if (dict.containsKey(c)) {
	             if (found.containsKey(c)) {
	                 if (found.get(c) < dict.get(c))
	                     foundCounter++;
	                 found.put(c, found.get(c) + 1);
	             } else {
	                 found.put(c, 1);
	                 foundCounter++;
	             }
	         }
	         if (foundCounter == T.length()) {
	             //When foundCounter equals to T.length(), in other words, found all characters.
	             char sc = S.charAt(start);
	             while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
	                 if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
	                     found.put(sc, found.get(sc) - 1);
	                 start++;
	                 sc = S.charAt(start);
	             }
	             if (end - start + 1 < min) {
	                 minWindow = S.substring(start, end + 1);
	                 min = end - start + 1;
	             }
	         }
	         end++;
	     System.out.println(" end "+end+" count "+foundCounter+" "+minWindow);
	     }
	     return minWindow;
	 }
 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow m=new minWindow();
		System.out.println(m.minWindow3("adbccbad", "abc"));
	}

}
