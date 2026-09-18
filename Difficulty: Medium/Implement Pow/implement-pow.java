class Solution {
    double power(double b, int e) {
        // code here
        long exp=e;
        if(exp<0){
            b=1/b;
            exp=-exp;
        }
        return power(b, exp, 1);
    }
    double power(double b, long e, double ans){
        if(e==0){
            return ans;
        }
        if(e%2!=0){
            ans*=b;
        }
        return power(b*b, e/2, ans);
    }
}