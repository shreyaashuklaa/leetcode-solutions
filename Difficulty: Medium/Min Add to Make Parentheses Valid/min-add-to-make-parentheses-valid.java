class Solution {
    public int minParentheses(String s) {
        // code here
        int open=0;
        int closing=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    closing++;
                }
            }
        }
        return open+closing;
    }
}
