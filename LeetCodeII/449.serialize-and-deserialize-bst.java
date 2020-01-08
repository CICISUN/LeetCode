/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (45.98%)
 * Total Accepted:    55.3K
 * Total Submissions: 118.5K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CodecBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
//        return sb.length() > 0 ? sb.toString().substring(0, sb.length() - 1) : sb.toString();
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if( node == null) {
            return;
        }
        sb.append(node.val + ",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        if(data == null || "".equals(data)) return null;
        if(data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        for(int i= 1; i< nodes.length; i++) {
            insert(root, Integer.parseInt(nodes[i]));
        }
        return root;
    }

    private void insert(TreeNode node, int val) {
        if(node == null) return;
        TreeNode pre = null;
        while(node != null) {
            pre = node;
            if(val < node.val) {
                node = node.left;
            } else if (val > node.val) {
                node = node.right;
            }
        }
        if(val < pre.val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
    }


    public TreeNode deserialize2(String data) {
        if (data.length() == 0) return null;
        int[] pos = {0};
        return deserialize2Helper(data.split(","), pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize2Helper(String[] nodes, int[] pos, int min, int max) {
        if (pos[0] == nodes.length) return null;
        int val = Integer.valueOf(nodes[pos[0]]);
        if(val < min || val > max) {
            return null;
        }
        TreeNode cur = new TreeNode(val);
        pos[0]++;
        cur.left = deserialize2Helper(nodes, pos, min, val);
        cur.right = deserialize2Helper(nodes, pos, val, max);
        return cur;
    }

    public static void main(String[] args) {

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        CodecBST r  = new CodecBST();
        System.out.println(r.deserialize2(r.serialize(a)));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
