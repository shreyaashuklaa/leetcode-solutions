class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both are null
        if (left == null && right == null) {
            return true;
        }
        // One is null
        if (left == null || right == null) {
            return false;
        }
        // Values should match and children should be mirrors
        return (left.val == right.val) && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}