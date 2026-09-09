class Solution {
    private int numberOfGasStationsRequired(double dist, int[] stations) {
        int cnt = 0;
        for (int i = 1; i < stations.length; i++) {
            int numberInBetween =
                    (int) ((stations[i] - stations[i - 1]) / dist);

            if ((stations[i] - stations[i - 1]) / dist
                    == numberInBetween * dist) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
    public double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            high = Math.max(high,
                    (double) (stations[i + 1] - stations[i]));
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, stations);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}