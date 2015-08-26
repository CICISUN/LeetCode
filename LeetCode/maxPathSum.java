package LeetCode;

public class maxPathSum {
	
    public int maxPathSum(TreeNode root) {
        int maxsofar = Integer.MIN_VALUE, sum=0;
        int res = dfs(root, sum,maxsofar);
        return res;
    }
    
    private int dfs(TreeNode r, int sum, int maxsofar){
        if(r==null) return maxsofar;
        sum = sum+r.val;
        if(r.left==null && r.right==null && sum > maxsofar){
            maxsofar = sum;
        }
        dfs(r.left, sum, maxsofar);
        dfs(r.right, sum, maxsofar);
        return maxsofar;
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPath(root, res);
        return res[0];
    }
    private int maxPath(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int left = maxPath(root.left, res);//左边一支儿（不算自己）
        int right = maxPath(root.right, res);
        int arch = left + right + root.val; //穿过自己
        int single = Math.max(root.val, Math.max(left, right) + root.val);//（算上自己）
        res[0] = Math.max(res[0], Math.max(arch, single));//update结果
        return single;
    }
    public int maxPathSum2(TreeNode root) {
        int maxsofar = Integer.MIN_VALUE, sum=0;
        dfs(root, sum,maxsofar);
        return maxsofar;
    }
    
    private void dfs2(TreeNode r, int sum, int maxsofar){
        if(r==null) return;
        sum = sum+r.val;
        if(r.left==null && r.right==null && sum > maxsofar){
            maxsofar = sum;
        }
        dfs(r.left, sum, maxsofar);
        dfs(r.right, sum, maxsofar);
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
