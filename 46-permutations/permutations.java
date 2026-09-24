class Solution {
    void solve(List<Integer> nums, List<Integer> curr,List<List<Integer>> ans) {

        // Base Case
        if(nums.size() == 0) {    // If no elements are left, one permutation is formed
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.size(); i++) {           // Try every element as the next choice
            int x = nums.get(i);                     // Pick current element
            // Create remaining list
            List<Integer> rem = new ArrayList<>(nums);
            rem.remove(i);
            curr.add(x);             // Add chosen element to current permutation
            solve(rem, curr, ans);
            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();              // Convert array into list for easy removal
        for(int x : nums) {
            list.add(x);
        }
        List<List<Integer>> ans = new ArrayList<>();
        solve(list, new ArrayList<>(), ans);        //RECURSION
        return ans;
    }
}