package LeetCode;

import java.util.Stack;

public class isValid {
	 public boolean isValid(String s) {
		    Stack<Character> stk=new Stack<Character>();
		    for(int i=0;i<s.length();i++){
		        Character tmp=s.charAt(i);
		        if(stk.isEmpty() && (tmp==')' || tmp==']' || tmp=='}')) return false;
		        if(!stk.isEmpty() && isMatch(stk.peek(), tmp)) 
		            stk.pop();
		        else stk.push(tmp);
		    } return stk.isEmpty();
		}
		  private boolean isMatch(Character a, Character b){
		    if(a=='(' && b==')') return true;
		    if(a=='[' && b==']') return true;
		    if(a=='{' && b=='}') return true;
		    else return false;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
