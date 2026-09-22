class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        // Stores the current partition path
        List<String> path = new ArrayList<>();
        // Start recursion from index 0
        solve(0, s, path, ans);
        return ans;
    }
    private void solve(int index, String s, List<String> path, List<List<String>> ans) {
        // Base Case:
        // If we have reached the end of the string,
        // one valid palindrome partition is formed.
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // Try every possible substring starting from 'index'
        for (int i = index; i < s.length(); i++) {
            // Check if substring s[index...i] is palindrome
            if (isPalindrome(s, index, i)) {
                // Choose
                path.add(s.substring(index, i + 1));
                // Explore remaining string recursively
                solve(i + 1, s, path, ans);
                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        // Two pointer palindrome check
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}