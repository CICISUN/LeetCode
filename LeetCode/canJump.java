package LeetCode;

public class canJump {

	   public boolean canJump(int[] nums) {
	        if(nums==null || nums.length==0) return false;
	        int count = 0, index = 0, n = nums.length;
	        return dfs(count, index, n, nums);
	    }
	    
	    boolean dfs(int count, int index, int n, int[] nums){
	    	if(index >= n) return false;
	        for(int i=0; i<=nums[index];i++){
	            if(count== n) return true;
	            if(count > n) continue;
	            count+=i;
	            dfs(count, index+1, n, nums);
	        }
	        return false;
	    }
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		canJump c = new canJump();
		int[] nums={1,1,1};
		System.out.println(c.canJump(nums));
	}

}
