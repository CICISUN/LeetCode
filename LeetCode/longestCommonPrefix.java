package LeetCode;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==0) return "";
        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<strs[0].length();i++){
            char tmp = strs[0].charAt(i);
            for(String s: strs){
                if(i+1>s.length() || s.charAt(i)!=tmp) return sb.toString();
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestCommonPrefix l =new longestCommonPrefix();
		String[] A={"A",""};
		System.out.println(l.longestCommonPrefix(A));
 
	}

}
