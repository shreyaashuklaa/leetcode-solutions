class Solution {

    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int median(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 1;
        int high = 2000;

        int req = (n * m) / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}