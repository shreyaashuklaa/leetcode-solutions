class Solution {
    static void solve(int[] arr, int target, int index, ArrayList<ArrayList<Integer>> ans, List<Integer> output){
        if(target==0){
            ans.add(new ArrayList(output));
            return;
        }
        if(target<0){
            return;
        }
        if(index>=arr.length){
            return;
        }
        output.add(arr[index]);
        solve(arr, target-arr[index], index, ans, output);
        output.remove(output.size()-1);
        solve(arr,target, index+1, ans, output);
    }
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        int index=0;
        solve(arr, target, index, ans, output);
        return ans;
        // code here
        
    }
}