class Solution {
    public String baseNeg2(int n) {
        String res = "";
        if (n == 0) return "0";
        while (n != 0) {
            int rem = n % -2;
            n = n / -2;
            if (rem < 0) {
                rem = rem + 2;
                n = n + 1;
            }

            res += rem;
        }
        StringBuilder sb = new StringBuilder(res);
        return sb.reverse().toString();
    }
}