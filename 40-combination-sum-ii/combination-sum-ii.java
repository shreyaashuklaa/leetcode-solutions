class Solution {
    static void solve(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> output){
        if(target==0){
            ans.add(new ArrayList(output));
            return;
        }
        if(index>=candidates.length){
            return;
        }
        if(target<0){
            return;
        }
        output.add(candidates[index]);
        //include
        solve(candidates, target-candidates[index], index+1, ans, output);
        //backtrack
        output.remove(output.size()-1);
        while(index+1 <candidates.length && candidates[index]==candidates[index+1]){
            index++;
        }
        //solve
        solve(candidates, target,index+1, ans, output);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        Arrays.sort(candidates);
        int index=0;
        solve(candidates, target, index, ans, output);
        return ans;
        
    }
}