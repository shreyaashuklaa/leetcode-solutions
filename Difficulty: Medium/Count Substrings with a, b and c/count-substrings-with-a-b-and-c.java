class Solution {
    public static int countSubstring(String s) {
        // code here
        int[] last={-1 ,-1, -1};
        int ans=0;
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
            ans+=Math.min(last[0], Math.min(last[1],last[2]))+1;
        }
        return ans;
        
    }
}
