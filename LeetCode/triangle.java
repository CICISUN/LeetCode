package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class triangle {
	
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows<=0) return res;
        List<Integer> rowone=new ArrayList<Integer>();
        rowone.add(1);
        res.add(rowone);
        if(numRows==1) return res;
        int row=2;
        while(row<=numRows){
            List<Integer> tmp=new ArrayList<Integer>();
            tmp.add(1); //first 
            for(int i=0;i<row-2;i++){
                tmp.add(res.get(row-2).get(i) + res.get(row-2).get(i+1));
            }
            tmp.add(1); //last
            res.add(tmp);
            row++;
        }
        return res;
    }
    
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<Integer>();
        pre.add(1);
        if(rowIndex==0) return pre;
        int row=1;
        while(row<=rowIndex){
            List<Integer> cur=new ArrayList<Integer>();
            cur.add(1); //first 
            for(int i=0;i<pre.size()-1;i++){
                cur.add(pre.get(i) + pre.get(i+1));
            }
            cur.add(1); //last
            pre=cur;
            row++;
        }
        return pre;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
