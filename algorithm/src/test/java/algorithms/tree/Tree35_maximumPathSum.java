package algorithms.tree;
/*
 * 
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any node sequence from some starting node to any node 
in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
 */

public class Tree35_maximumPathSum {

int max_sum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
    
    private int max_gain(TreeNode root){
        if(root == null) return 0;
        
        //left tree sum
        int left_gain = Math.max(max_gain(root.left), 0);
        //right tree sum
        int right_gain = Math.max(max_gain(root.right), 0);
        
        //whole path sum
        int max_path = root.data + left_gain + right_gain;
        
        //max sum
        max_sum = Math.max(max_sum, max_path);
        
        return root.data + Math.max(left_gain, right_gain);
    }
}