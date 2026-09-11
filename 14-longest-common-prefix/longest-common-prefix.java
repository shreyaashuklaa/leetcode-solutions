class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen=strs[0].length();
        for(String str: strs){
            minLen=Math.min(minLen, str.length());
        }
        int i=0;
        while(i<minLen){
            int j=0;
            while(j<strs.length-1){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i)){
                    return strs[0].substring(0,i);
                }
                j=j+1;
            }
            i=i+1;
        }
        return strs[0].substring(0,i);
    }
}
