class Solution {

    public String longestPrefix(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        // Build LPS array
        while (i < n) {

            // Characters match
            if (s.charAt(i) == s.charAt(len)) {

                len++;
                lps[i] = len;
                i++;
            }

            // Characters do not match
            else {

                // Try smaller prefix
                if (len != 0) {
                    len = lps[len - 1];
                }

                // No prefix available
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Length of longest happy prefix
        int happyLength = lps[n - 1];

        return s.substring(0, happyLength);
    }
}