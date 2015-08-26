import java.util.Hashtable;


public class lengthOfLongestSubstring {
	
	 public int lengthOfLongestSubstring(String s) {
		    if(s==null||s.length()==0) return 0;
		    int maxlen=1,l=0,r=0;
		    Hashtable <Character, Boolean> map=new Hashtable<Character, Boolean>();
		    while(r<s.length()){
		    	char tmp=s.charAt(r);
		    	if(!map.containsKey(tmp)||map.get(tmp)==false){
		    		map.put(tmp, true);
		    		maxlen=Math.max((r-l+1), maxlen);
		    	}
		    	else{
		    		while(s.charAt(l)!=s.charAt(r)){map.put(s.charAt(l), false);l++;}
		    		l++;
		    	}
		    	r++;
		    }
		    
		    return maxlen;
//		    for(int i=0;i< s.length();i++){
//		        for(int j=i;j<s.length();j++){
//		            if(map.containsKey(s.charAt(j))){map.clear(); break;}
//		            else{map.put(s.charAt(j), true);}
//		            int len=map.size();
//		            if(len>maxlen){maxlen=len;}
//		        }
//		    }
//		        return maxlen;
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring l=new lengthOfLongestSubstring();
		String s="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(l.lengthOfLongestSubstring(s));
		

	}

}
