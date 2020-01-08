/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (39.61%)
 * Total Accepted:    175.8K
 * Total Submissions: 435.4K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * Example: 
 *
 *
 * You may serialize the following tree:
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 *
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CodecBT {


    // Encodes a tree to a single string.
    public String serializeDFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            dfs(root, sb);
        }
        return sb.toString();
    }


    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("#,");
                continue;
            }
            sb.append(cur.val + ",");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        for(int i=1; i<nodes.length; i++) {
            TreeNode cur = q.poll();
            if(!"#".equals(nodes[i])){
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.left);
            }
            i++;
            if(!"#".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.right);
            }
        }
        return root;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserializeDFS(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split(",");
        int[] pos = {0};
        return insert(nodes, pos);
    }

    private TreeNode insert(String[] nodes, int[] pos) {
        if("#".equals(nodes[pos[0]])){
            pos[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(nodes[pos[0]]));
        pos[0]++;
        cur.left = insert(nodes, pos);
        cur.right = insert(nodes, pos);
        return cur;
    }

//    public static void main(String[] args) {
//        CodecBT c = new CodecBT();
//        c.deserializeDFS(c.serializeDFS(null));
//    }
}

// * ⁠   1
// * ⁠  / \
// * ⁠ 2   3
// preorder: 1,2,#,#,3,#,#
// bfs: 1,2,3
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74260/Recursive-DFS-Iterative-DFS-and-BFS

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

