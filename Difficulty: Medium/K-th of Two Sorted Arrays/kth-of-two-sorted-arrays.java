class Solution {
    public int kthElement(int a[], int b[], int k) {
        if(b.length<a.length){
                    return kthElement(b, a, k);
                }
                int l = Math.max(0, k - b.length);
                int h = Math.min(k, a.length);
                while(l<=h){
                    int m1=l+(h-l)/2;
                    int m2 = k - m1;

                    int l1=(m1==0) ? Integer.MIN_VALUE: a[m1-1];
                    int r1=(m1==a.length) ? Integer.MAX_VALUE: a[m1];

                    int l2=(m2==0)? Integer.MIN_VALUE: b[m2-1];
                    int r2=(m2==b.length)? Integer.MAX_VALUE: b[m2];

                    if(l1<=r2 && l2<=r1){
                        return Math.max(l1, l2);

                    }else if(l2>r1){
                        l=m1+1;
                    }else{
                        h=m1-1;
                    }

                }
                return -1;
        
    }
}