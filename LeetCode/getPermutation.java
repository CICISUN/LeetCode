package LeetCode;

import java.util.ArrayList;

public class getPermutation {

    public static String getPermutation(int n, int k) {
        int[] count={0};
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp = dfs(tmp, n, k, count);
        StringBuilder re= new StringBuilder();
        for(int i : tmp){
        	re.append(i);
        }
        return re.toString();
    }
    private static ArrayList<Integer> dfs(ArrayList<Integer> tmp, int n , int k, int[] count){
    
    	if(tmp.size() == n){
    		count[0]++;
    		if(count[0]==k) return tmp;
    		else return null;
    	}
    	for(int i=1; i<=n; i++){
    		if(tmp.contains(i)) continue;
    		tmp.add(i);
    		ArrayList<Integer> res = dfs(tmp, n, k, count);
    		if(res!= null) return res;
    		tmp.remove(tmp.size()-1);
    	}
    	return null;
    }
     
    public static String getPermutation2(int n, int k){
    	StringBuilder sb = new StringBuilder();
    	k=k-1;
    	int factorial=1;
    	for(int i=1;i<n;i++){
    		factorial*=i;
    	}
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }
        while(n>1){
        	int index = k/factorial;
        	//System.out.println(index+":"+factorial+":"+k+":"+n+":"+sb.toString());
        	sb.append(nums.get(index));
        	nums.remove(index);
        	k = k%factorial;
        	factorial = factorial/(n-1);
        	 
        	n--;
        }
        sb.append(nums.get(0));
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation2(3,2));
	}

}
