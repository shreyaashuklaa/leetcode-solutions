class Solution {
    public void solve(int index, int[] nums,List<Integer> current,List<List<Integer>> ans) {
        // Add current subset
        ans.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Pick
            current.add(nums[i]);
            solve(i + 1, nums, current, ans);
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}