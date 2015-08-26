
public class isScramble {
	
	 public boolean isScramble(String s1, String s2) {
	      //check length
	    	if(s1.length()!=s2.length()) return false;
	    	int i=0;int L = s1.length();
	    	if(s1.equals(s2)) return true;
	  
		    	// check letters
		    	int[] count=new int[26];
		    	for(;i<L;i++){
		    		count[s1.charAt(i)-'a']++;
		    		count[s2.charAt(i)-'a']--;
		    	}
		    	for(i=0;i<26;i++){
		    		if(count[i]!=0) return false;
		    	}
	 
	    	//check scramble
	    	for(i=1;i<L;i++){
	    		String s11=s1.substring(0, i);
	    		String s12=s1.substring(i);
	    		String s21=s2.substring(0,i);
	    		String s22=s2.substring(i);
	    		if(isScramble(s11,s21)&&isScramble(s12,s22)) return true;
	    		else {
	    			s21=s2.substring(0,L-i);
	    			s22=s2.substring(L-i);
	    			if(isScramble(s11,s22)&&isScramble(s12,s21)) return true;
	    		}
	    	}return false;
	    }
	 
	  public boolean isScramble2(String s1, String s2) {
		    if(s1.length()!=s2.length()) return false;
		    if(s1.equals(s2)) return true;
		    int L=s1.length();
		    boolean [][][] t=new boolean[L][L][L+1];
		    //init base value
		    for(int i=0;i<L;i++){
		        for(int j=0;j<L;j++){
		            t[i][j][1] = s1.charAt(i)==s2.charAt(j);
		           
		        }
		    }
		    //calculate the whole table
		    for(int len=2;len<=L;len++){
		        for(int i=0;i<L-len+1;i++){
		            for(int j=0;j<L-len+1;j++){
		                for(int k=1;k<len;k++){
		                	if(!t[i][j][len])
		                	 t[i][j][len]=(t[i][j][k] &&  t[i+k][j+k][len-k] || t[i][j+len-k][k] && t[i+k][j][len-k]) ;
		                	 System.out.println(i+" "+j+" "+k+" "+len+" "+t[i][j][len]);
		                    }
		                }
		            }
		        }
			 //return the last value
			 return t[0][0][L];
			 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="avab";
		System.out.println(s.substring(3,3));
		isScramble i=new isScramble();
		System.out.println(i.isScramble2("abc", "acb"));
	}

}
