import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();

        // Base index
        st.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(i);
            } else {

                // Remove matching '('
                st.pop();

                // No valid starting point left
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    // Length of current valid substring
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}