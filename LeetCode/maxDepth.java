import java.util.LinkedList;



public class maxDepth {
    public int maxDepth(TreeNode root) {
        int depth=0;
        LinkedList<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode levelend=root, tmp;
        while(!q.isEmpty()){
            tmp=q.poll();
            if(tmp.left!=null) q.offer(tmp.left);
            if(tmp.right!=null) q.offer(tmp.right);
            if(tmp==levelend){
                depth++;
                levelend=q.peekLast();
            }
        } return depth;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
