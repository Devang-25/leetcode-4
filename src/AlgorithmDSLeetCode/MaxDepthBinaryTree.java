package AlgorithmDSLeetCode;

//Java program to find height of tree

//A binary tree node
class Node 
{
 int data;
 Node left, right;

 Node(int item) 
 {
     data = item;
     left = right = null;
 }
}
public class MaxDepthBinaryTree {
	
	Node root;
	
	public int maxDepth(Node root) {
        if (root == null ) return 0;
    int Value = root.data;    
    int finalValue =  1+Math.max(maxDepth(root.left),maxDepth(root.right));
    return finalValue;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + 
                                      tree.maxDepth(tree.root));
    
	}

}
