class Solution {
    static void solve(int[] candidates, int target, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> output, int count , int k){
        if(count>k){
            return;
        }
        if(count==k && target==0){
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
        solve(candidates, target-candidates[index], index+1, ans, output, count+1, k);
        //backtrack
        output.remove(output.size()-1);
        while(index+1 <candidates.length && candidates[index]==candidates[index+1]){
            index++;
        }
        //solve
        solve(candidates, target,index+1, ans, output, count, k);
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        int index=0;
        int target=n;
        int[] candidates={1,2,3,4,5,6,7,8,9};
        int count=0;
        solve(candidates, target, index, ans, output, count, k);
        return ans;

    }
}