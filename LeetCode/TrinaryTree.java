package LeetCode;

public class TrinaryTree {
	/**
	 * Implementation of Insertion and Deletion on a Ternary Tree
	 * @param      root   the root of current tree. When initialize a tree without root, do insert(null, value) to insert root
	 * Assumption  My definition of insertion is that all nodes smaller than root is inserted into left subtree, and if duplicate
	 * 			   happens just insert it down the former node, vice versa.
	 * Limitation  Given a set of input, there are multiple valid Ternary Tree, my insertion algorithm only output one 
	 */

	TrinaryNode root;
	TrinaryTree(){
		root = null;
	}
	TrinaryTree(int x){
		root = new TrinaryNode(x);
	}

	//Insertion
	TrinaryNode insert(TrinaryNode root, int x){

		TrinaryNode tmp = new TrinaryNode(x);
		//Insert root if root is not set
		if(root==null){
			root = tmp;
			return root;
		}
		//Find target position in left subtree if x is smaller than current node
		if(root.val > x){
			if(root.left==null){
				root.left = tmp;
			}
			else{
				insert(root.left, x);
			}
		}
		//Find target position in right subtree if x is larger than current node
		if(root.val < x){
			if(root.right==null){
				root.right = tmp;
			}
			else{
				insert(root.right, x);
			}
		}
		//Find target position in middle subtree if x is equal to current node
		if(root.val == x){
			if(root.middle==null){
				root.middle = tmp;
			}
			else{
				insert(root.middle, x);
			}
		}
		return root;
	}

	//Deletion
	TrinaryNode delete(TrinaryNode root, int x){
		//Target node is in left subtree
		if(root.val > x){
			root.left = delete(root.left, x);
		}
		//Target node is in right subtree
		else if(root.val < x){
			root.right = delete(root.right, x);
		}
		//Target node equals current node
		else if(root.middle != null){
			//Delete middle node that is equal to current node
			root.middle = delete(root.middle ,x);
		}
		//Replace current node with its successor in right subtree
		else if(root.right !=null){ 
			root.val = Sucessor(root.right).val;
			delete(root, Sucessor(root.right).val);
		}
		//Transplant left subtree directly
		else {
			root = root.left;
		}
		return root;
	}

	//Function to find successor in right subtree
	TrinaryNode Sucessor(TrinaryNode root){
		TrinaryNode tmp = root;
		while(tmp.left!=null){
			tmp=tmp.left;
		} 
		return tmp;
	}

	//Function to in-order traverse the tree for testing purpose
	void test_print(TrinaryNode root){
		if (root!=null){
			System.out.println("Node Value: " + root.val);
		}
		else return;
		test_print(root.left);
		test_print(root.middle);
		test_print(root.right);
	}

	public static void main(String[] args) {

		TrinaryTree test_tree = new TrinaryTree();
		TrinaryNode root = test_tree.insert(null, 5);
		//insert
		int [] nodes = {5, 4, 9, 5, 7, 2, 2};
//		int [] nodes = {5,3,3,2,2,1,4,6,4,6,8,14};
		for(int i=0;i<nodes.length;i++){
			test_tree.insert(root, nodes[i]);
		}
//		test_tree.test_print(root);
		//delete
		test_tree.delete(root, 2);
		//print
		test_tree.test_print(root);
	}
}
