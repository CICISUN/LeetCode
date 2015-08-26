package LeetCode;

import java.util.ArrayList;
import java.util.List;


public class findmissingRanges {
	
	public ArrayList<String> findmissingRanges(int[] num, int lower, int upper){
		ArrayList<String> res=new ArrayList<String>();
	 
			if(num.length==0){
				if(lower!=upper) res.add(lower+"->"+upper);
				else res.add(lower+"");
				return res;
			}
			if(lower<num[0]){
				if(num[0]-lower>1) res.add(lower+"->"+(num[0]-1));
				else res.add(lower+"");
			}
			
			for(int i = 0;i<num.length-1;i++){
				if(num[i+1]-num[i]>2) res.add((num[i]+1)+"->"+(num[i+1]-1)+"");
				else if(num[i+1]-num[i]==2) res.add(num[i]+1+"");
				else continue;
			}
			
			if(num[num.length-1]<upper){
				if(upper-num[num.length-1]>1) res.add(num[num.length-1]+1+"->"+upper);
				else res.add(""+upper);
			}
			return res;

	}
	
	 public List<String> findMissingRanges(int[] vals, int start, int end) {
	        List<String> ranges = new ArrayList<String>();
	        int prev = start - 1;
	        for (int i=0; i<=vals.length; i++) {
	            int curr = (i==vals.length) ? end + 1 : vals[i];
	            if ( curr-prev>=2 ) {
	                ranges.add(getRange(prev+1, curr-1));
	            }
	            prev = curr;
	        }
	        return ranges;
	    }
	 
	    private String getRange(int from, int to) {
	        return (from==to) ? String.valueOf(from) : from + "->" +to;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findmissingRanges r=new findmissingRanges();
		int[] S={0, 1, 3, 50, 75};
		System.out.println(r.findMissingRanges(S, 0, 76));

	}

}
