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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        preorder(root, "", result);
        return result;
    }

    private void preorder(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }

        // 1. ROOT: Current node ko path mein jodein
        if (node.left == null && node.right == null) {
            // Leaf node milne par final path list mein add karein
            result.add(path + node.val);
            return;
        }

        // 2. LEFT: Left subtree par jaayein
        preorder(node.left, path + node.val + "->", result);

        // 3. RIGHT: Right subtree par jaayein
        preorder(node.right, path + node.val + "->", result);
    }
}
