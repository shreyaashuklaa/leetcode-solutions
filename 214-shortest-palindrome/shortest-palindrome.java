class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        // Original + separator + reverse
        String combined = s + "#" + rev;
        int[] lps = buildLPS(combined);

        // Length of longest palindromic prefix
        int palindromeLength = lps[lps.length - 1];

        // Remaining part of string
        String suffix = s.substring(palindromeLength);

        // Reverse remaining part and add in front
        String prefixToAdd =
                new StringBuilder(suffix).reverse().toString();

        return prefixToAdd + s;
    }
    private int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}