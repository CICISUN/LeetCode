package LeetCode;

import java.util.Stack;

public class simplifyPath {
	
	 public static String simplifyPath(String path) {
	        String[] s=path.split("/");
	   
	        System.out.println(s.toString());
	        
	        Stack<String> stk = new Stack<String>();
	        for(int i=0;i<s.length;i++){
	            if(s[i].equals("..") && !stk.isEmpty()) stk.pop();
	            else if(!s[i].equals("") && !s.equals(".")) stk.push(s[i]);
	        }
	        String res="";
	        if(stk.isEmpty()) return "/";
	        while(!stk.isEmpty()){
	        	res = "/" + stk.pop() + res;
	        }
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/."));
	}

}
