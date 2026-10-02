class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    private void backtrack(List<String> ans,String curr,int open,int close,int n) {
        // Base Case:
        // If length becomes 2*n, one valid combination is formed
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }
        // Choice 1: Add '(' if we still have opening brackets left
        if (open < n) {
            backtrack(ans, curr + "(", open + 1, close, n);
        }
        // Choice 2: Add ')' only when it won't make string invalid
        if (close < open) {
            backtrack(ans, curr + ")", open, close + 1, n);
        }
    }
}