package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class letterCombinations {

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		if(digits==null || digits.length()==0) return res;
		LinkedList<String> list = new LinkedList<String>();
		list.add("");
		for(int i=0;i<digits.length();i++){
			int num = digits.charAt(i) - '0';
			int size = list.size();
			for(int j=0;j<size;j++){
				String tmp = list.poll();
				for(int k=0;k<map[num].length();k++){
					list.add(tmp + map[num].charAt(k));
				}
			}
		}
		res.addAll(list);
		return res;
	}
	
	public ArrayList<String> letterCombinations(String digits) {
		String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder tmp = new StringBuilder();
        ArrayList<String> res = new ArrayList<String>();
        dfs(digits, map, tmp, res, 0);
        return res;
	}
	private void dfs(String digits, String[] map, StringBuilder tmp, ArrayList<String> res, int height){
	    if(height == digits.length()){
	        res.add(tmp.toString());
	        return;
	    }
	    else{
	    int num = digits.charAt(height)-'0';
	    for(int i=0; i<map[num].length();i++){
	         tmp.append(map[num].charAt(i));
	         dfs(digits, map, tmp, res, height+1);
	    }
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
