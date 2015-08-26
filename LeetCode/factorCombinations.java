package LeetCode;

import java.util.ArrayList;

/*****
 *@author CC
 *Print all unique combinations of factors of a positive integer. For example given 24:
 *24*1
 *12*2
 *8*3
 *6*4
 *6*2*2
 *4*3*2
 *3*2*2*2
 */

public class factorCombinations {
	
	public ArrayList<ArrayList<Integer>> factorCombinations(int n){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		ArrayList<Integer> first=new ArrayList<Integer>();
		first.add(n);first.add(1);
		res.add(first);
		res=dfs(res, n, n/2, tmp);
		return res;
	}

	private ArrayList<ArrayList<Integer>> dfs(ArrayList<ArrayList<Integer>> res, int Curdividend, int Largestdivisor, ArrayList<Integer> tmp){
		if(Curdividend==1){
			res.add(new ArrayList<Integer>(tmp));
			return null;
		}

		for(int i=Largestdivisor; i>1;i--){
			if(Curdividend%i==0){
				tmp.add(i);
				dfs(res,Curdividend/i, i,tmp);
				tmp.remove(tmp.size()-1);
			}
		}
		return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorCombinations f= new factorCombinations();
		ArrayList<ArrayList<Integer>> res=f.factorCombinations(24);
		for(ArrayList<Integer> r: res){
			System.out.println(r);
		}
		
	}

}
