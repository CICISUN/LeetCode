import java.util.ArrayList;
import java.util.Arrays;


public class subsets {
	
	 public ArrayList<ArrayList<Integer>> subsets(int[] num) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(num == null || num.length == 0) {
	            return result;
	        }
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        result.add(new ArrayList<Integer>(list));
	        Arrays.sort(num);  
	        subsetsHelper(result, list, num, 0);

	        return result;
	    }


	    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
	        ArrayList<Integer> list, int[] num, int pos) {

	     
	        for (int i = pos; i < num.length; i++) {
	        	
	            list.add(num[i]);
	            result.add(new ArrayList<Integer>(list));
	            System.out.println("1: "+"num "+num[i]+" list "+list+"res "+result);
	            subsetsHelper(result, list, num, i + 1);
	            System.out.println("2: "+"num "+num[i]+" list "+list+"res "+result);
	            list.remove(list.size() - 1);
	            System.out.println("3: "+"num "+num[i]+" list "+list+"res "+result);
	        }
	    }

	    
	  //inintialize a {}, keep inserting, mark as used (distinct nums)
	    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
	        ArrayList<Integer> subset=new ArrayList<Integer>();
	        ArrayList<ArrayList<Integer>> subsets=new ArrayList<ArrayList<Integer>> ();
	        //add empty set
	        subsets.add(new ArrayList<Integer>());
	        //add set from layers 
	        for(int i=0;i<S.length;i++){
	             ArrayList<ArrayList<Integer>> subsetsfori=new ArrayList<ArrayList<Integer>>();
	            for(ArrayList<Integer> prev: subsets){
	                ArrayList<Integer> tmp= new ArrayList<Integer>();
	                tmp.addAll(prev);
	                tmp.add(S[i]);
	                subsetsfori.add(tmp);
	        }
	        subsets.addAll(subsetsfori);
	    }
	    return subsets;
	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets s=new subsets();
		int[] S = {1,2,3};
		System.out.println(s.subsets(S));

	}

}
