class Solution {
    public int myAtoi(String s) {
        int i = 0;                  // Pointer to traverse the string
        int n = s.length();
        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // If string contains only spaces
        if (i == n) {
            return 0;
        }
        // Step 2: Check sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        // Step 3: Build number
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            // Step 4: Handle overflow
            if (sign * num <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(sign * num);
    }
}