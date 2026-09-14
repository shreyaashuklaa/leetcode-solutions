class Solution {

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Step 1: Build LPS array for pattern
        int[] lps = buildLPS(needle);

        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        // Step 2: Start matching
        while (i < n) {

            // Characters match
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            // Entire pattern matched
            if (j == m) {
                return i - j;
            }

            // Mismatch occurs
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {

                // Use LPS to avoid rechecking characters
                if (j != 0) {
                    j = lps[j - 1];
                }
                // No previous match exists
                else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {

            // Characters match
            if (pattern.charAt(i) == pattern.charAt(len)) {

                len++;
                lps[i] = len;
                i++;
            }
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

        return lps;
    }
}