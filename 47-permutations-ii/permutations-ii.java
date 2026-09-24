class Solution {
    void solve(List<Integer> nums, List<Integer> curr, List<List<Integer>> ans) {
        if(nums.size() == 0) {         //base case
            ans.add(new ArrayList<>(curr));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            // Duplicate skip
            if(set.contains(x)) 
                continue;
            set.add(x);
            List<Integer> rem = new ArrayList<>(nums);
            rem.remove(i);
            curr.add(x);           // Choose current element
            solve(rem, curr, ans);          // Recurse for remaining elements
            curr.remove(curr.size() - 1);    //backtrack
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);        // Sorting helps place duplicates together
        List<Integer> list = new ArrayList<>();      // Convert array to list
        for(int x : nums)
            list.add(x);
        List<List<Integer>> ans = new ArrayList<>();
        solve(list, new ArrayList<>(), ans);         // Start recursion
        return ans;
    }
}