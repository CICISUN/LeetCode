
public class test {
	
  	public String longestPalindrome(String s) {
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
//                System.out.println("inner: count "+ count+" i "+i+" get(s, i - count) "+get(s, i - count)+" get(s, i + count) "+get(s, i + count));
            }
//            System.out.println("count "+ count+" i "+i+" get(s, i - count) "+(i-count)+" "+get(s, i - count)+" get(s, i + count) "+get(s, i + count));
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
		test t=new test();
		
		System.out.println(t.longestPalindrome("babbac"));
	}

}
