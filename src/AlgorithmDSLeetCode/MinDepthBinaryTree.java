package AlgorithmDSLeetCode;

import java.util.LinkedList;

public class MinDepthBinaryTree {

	
	 //Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
public int minDepth(TreeNode root) {
        
        if(root==null) return 0;
        
       int minLevel=0;
       LinkedList<TreeNode> nodeList = new LinkedList<>();
       nodeList.add(root);
       while(!nodeList.isEmpty()){
       nodeList = bfs(nodeList);
       minLevel++;
       System.out.println(minLevel);
       }
       return minLevel;
    }
    
    public static LinkedList<TreeNode> bfs(LinkedList<TreeNode> nodeList){
        
        LinkedList<TreeNode> newNodeList = new LinkedList<>();
        
        while(!nodeList.isEmpty()){
        TreeNode tempNode = nodeList.pollFirst();
        if(tempNode.left==null && tempNode.right==null) {
            nodeList.clear();
            return nodeList;
        }
        if(tempNode.left !=null) 
            newNodeList.add(tempNode.left);
        
        if(tempNode.right !=null) 
            newNodeList.add(tempNode.right);
        }
        return newNodeList;
    }
}
