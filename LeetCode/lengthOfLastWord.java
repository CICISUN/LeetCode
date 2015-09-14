package LeetCode;

public class lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        //if(s==null) return 0;
        s=s.trim();
        int i=s.length()-1;
        int len=0;
        while(i>=0 && s.charAt(i)>='A' && s.charAt(i)<='z'){
            i--;
        	len++;
        }
        return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord(""));
	}

}
