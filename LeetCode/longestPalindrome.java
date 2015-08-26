
public class longestPalindrome {
	
	 public String longestPalindrome(String s) {
	        int maxlen=0; 
	        String maxstr=null;
	        for(int i=0;i<s.length();i++){
	            for(int j=i+1;j<s.length();j++){
	                String tmp=s.substring(i,j+1);
	                if(IsPalindrome(tmp)&&tmp.length()>maxlen)
		            	{
	                	maxlen=tmp.length();
	                	maxstr=tmp;}
	            }
	        }return maxstr;
	    }
	  
	  public Boolean IsPalindrome(String s) {
	        for(int i=0;i<s.length();i++){
	        if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
	        } return true;
	    }
	  

	  public String longestPalindrome2(String s) {
		  	int maxlen=0; 
	        String maxstr=null;
	        int[][] t=new int[s.length()][s.length()];
	        for(int i=0;i<s.length();i++){t[i][i]=1;}
	        for(int i=0;i<s.length()-1;i++){
	        	if(s.charAt(i)==s.charAt(i+1))
	        		{t[i][i+1]=1;
	        		maxlen=2;maxstr=s.substring(i,i+2);}
	        	else t[i][i+1]=0;
	        	}
	        
//	        printTable(t);
	        
	        for (int len = 3; len <= s.length(); len++) {
	    		for (int i = 0; i <= s.length()-len; i++) {
	    			int j = i + len - 1;
	    			if (s.charAt(i) == s.charAt(j)) {
	    				t[i][j] = t[i + 1][j - 1];
	    				if (t[i][j] == 1 && len > maxlen)
	    					maxstr = s.substring(i, j + 1);
	    			} 
	    			else {t[i][j]=0;}
//	    			printTable(t);
	    		}
	    	}
	        
	        return maxstr;
	        
	  }
		
	  public static void printTable(int[][] x){
			for(int [] y : x){
				for(int z: y){
					System.out.print(z + " ");
				}
				System.out.println();
			}
			System.out.println("------");
		}
	  
	  
	  public String longestPalindrome4(String s) {
 
		 
			String maxstr = "";
			for (int i = 0; i < s.length(); i++) {
				// get longest palindrome with center of i eg: BAB
				String tmp = helper(s, i, i);
				if (tmp.length() > maxstr.length()) {
					maxstr = tmp;
				}
		 
				// get longest palindrome with center of i, i+1 eg: ABBA
				tmp = helper(s, i, i + 1);
				if (tmp.length() > maxstr.length()) {
					maxstr = tmp;
				}
			}
		 
			return maxstr;
		}
	  
	  public static String helper(String s, int begin, int end) {
			while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
				begin--;
				end++;
			}
			return s.substring(begin + 1, end);
			}
	  
	  public String longestPalindrome3(String s) {
	        if (s == null || s.length() == 0) {
	            return "";
	        }
	        
	        int length = s.length();    
	        int max = 0;
	        String result = "";
	        for(int i = 1; i <= 2 * length - 1; i++){
	        	System.out.println(i);
	            int count = 1;
	            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
	                count++;
//	                System.out.println("inner: count "+ count+" i "+i+" get(s, i - count) "+get(s, i - count)+" get(s, i + count) "+get(s, i + count));
	            }
//	            System.out.println("count "+ count+" i "+i+" get(s, i - count) "+(i-count)+" "+get(s, i - count)+" get(s, i + count) "+get(s, i + count));
	            count--; // there will be one extra count for the outbound #
	            if(count > max) {
	                result = s.substring((i - count) / 2, (i + count) / 2);
	                System.out.println(result);
	                max = count;
	            }
	        }
	        
	        return result;
	    }
	    
	    private char get(String s, int i) {
	    	System.out.println(i%2+" "+i/2);
	        if(i % 2 == 0)
	            return '#';
	        else 
	            return s.charAt(i / 2);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestPalindrome l=new longestPalindrome();
		System.out.println(l.longestPalindrome4("babbac"));
		

	}

}
