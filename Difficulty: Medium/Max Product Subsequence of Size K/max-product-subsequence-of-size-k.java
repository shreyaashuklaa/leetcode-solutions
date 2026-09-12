class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        long[] maxDp = new long[k + 1];
        long[] minDp = new long[k + 1];

        // Initialize
        for (int i = 0; i <= k; i++) {
            maxDp[i] = Long.MIN_VALUE;
            minDp[i] = Long.MAX_VALUE;
        }

        maxDp[0] = 1; // product of empty subsequence
        minDp[0] = 1;

        for (int num : arr) {

            // Traverse backwards to avoid reusing the same element
            for (int j = k; j >= 1; j--) {

                if (maxDp[j - 1] == Long.MIN_VALUE) continue;

                long p1 = maxDp[j - 1] * num;
                long p2 = minDp[j - 1] * num;

                long currMax = Math.max(p1, p2);
                long currMin = Math.min(p1, p2);

                if (maxDp[j] == Long.MIN_VALUE) {
                    maxDp[j] = currMax;
                    minDp[j] = currMin;
                } else {
                    maxDp[j] = Math.max(maxDp[j], currMax);
                    minDp[j] = Math.min(minDp[j], currMin);
                }
            }
        }

        return (int) maxDp[k];
    }
}