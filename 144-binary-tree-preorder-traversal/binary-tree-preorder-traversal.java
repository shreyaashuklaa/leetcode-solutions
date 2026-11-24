/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode node, ArrayList<Integer> result){
        if(node==null){
            return;
        }
        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }
}