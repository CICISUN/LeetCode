package LeetCode;

import java.util.ArrayList;

public class generateParenthesis {
	
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); 
        if(n==0) return res;
        dfs(res, sb, n, n);
        return res;
        
    }
    
    private void dfs(ArrayList<String> res, StringBuilder sb,int left, int right){
        if(left > right) return;
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }
        if(left>0){
            dfs(res,sb.append('('), left-1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right>0){
            dfs(res,sb.append(')'), left, right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis g = new generateParenthesis();
		System.out.println(g.generateParenthesis(2));

	}

}
