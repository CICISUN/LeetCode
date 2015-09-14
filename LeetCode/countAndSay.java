package LeetCode;

public class countAndSay {
	
    public static String countAndSay(int n) {
        if(n==0) return null;
        if(n==1) return "1";
    	String s="1";
        String news="1";
        for(int i=1;i<=n;i++){
            news="";
            for(int j=0;j<s.length();j++){
                int count=1;
                while(j+1<s.length() && s.charAt(j)==s.charAt(j+1)){
                     count++;
                     j++;
                }
                news+=String.valueOf(count)+s.charAt(j);
            }
            s=news;
        }
        return s;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
	}

}
