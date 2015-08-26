
public class isPalindrome {

	  public boolean isPalindrome(String s) {
	        if(s==null||s.length()==0) return true;
	        s=s.toUpperCase();
	        int l=0, r=s.length()-1;
	        while(l<r){
	        	System.out.println(l+" "+r);
	            Character tmpl=s.charAt(l), tmpr=s.charAt(r);
	    
	            if(!(tmpl>='0' && tmpl<='9' || tmpl>='A'&& tmpl<='Z')) {l++; continue;}
	            else if(!(tmpr>='0'&& tmpr<='9'||tmpr>='A'&&tmpr<='Z')) {r--;continue;}
	            
	            else{
	            	System.out.println(tmpl+" "+tmpr);
	            	if(tmpl.equals(tmpr)){l++;r--;}
	                else return false;
	            }
	           
	        }
	        return  true;
	    }
	  
	  public boolean isPalindrome(int x) {
	        int res=0,orig=x;
	        if(x<0) return false;
	        if(x/10==0) return true;
	        while(x/10!=0){
	        	
	            res=res*10+x%10;
	            x=x/10;
	           
	        } 
	        res=res*10+x%10;
	       
	        
	        return res==orig ? true:false;
	        
	    }
	  
	 public boolean isPalindrome2(int x) {
		  if (x < 0) return false;
		  int div = 1;
		  while (x / div >= 10) {
		    div *= 10;
		  }        
		  while (x != 0) {
		    int l = x / div;
		    int r = x % 10;
		    if (l != r) return false;
		    x = (x % div) / 10;
		    div /= 100;
		  }
		  return true;
		}
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome i=new isPalindrome();
		System.out.println(i.isPalindrome2(2147447412));
	}

}
