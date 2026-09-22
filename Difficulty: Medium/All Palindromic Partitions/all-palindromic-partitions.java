class Solution {
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0, s, path, ans);
        return ans;
    }
    private static void solve(int index, String s, List<String> path,  ArrayList<ArrayList<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index,i)){
                path.add(s.substring(index, i+1));
                solve(i+1, s, path, ans);
                path.remove(path.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
