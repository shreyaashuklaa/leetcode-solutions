class Solution {
    public double medianOf2(int a[], int b[]) {
        // COMPLEXITY IS O(m+n) but we want O(log(m+n)) so we'll optimise
        // int i=0, j=0, k=0;
        // int[] m=new int[a.length+b.length];
        // while(i<a.length && j<b.length){
        //     if(a[i]<b[j]){
        //         m[k]=a[i];
        //         i++;
        //         k++;
        //     }else{
        //         m[k]=b[j];
        //         j++;
        //         k++;
        //     }
        // }
        // while(i<a.length){
        //     m[k]=a[i];
        //     i++;
        //     k++;
        // }
        // while(j<b.length){
        //     m[k]=b[j];
        //     j++;
        //     k++;
        // }
        // if(m.length%2==0){
        //     int mid=m.length/2;
        //     return (double)(m[mid]+m[mid-1])/2;
        // }
        // else{
        //     int mid=m.length/2;
        //     return m[mid];
            
        // }
        if(b.length<a.length){
            return medianOf2(b, a);
        }
        int l=0, h=a.length;
        while(l<=h){
            int m1=l+(h-l)/2;
            int m2=((a.length+b.length+1)/2)-m1;
            
            int l1=(m1==0) ? Integer.MIN_VALUE: a[m1-1];
            int r1=(m1==a.length) ? Integer.MAX_VALUE: a[m1];
            
            int l2=(m2==0)? Integer.MIN_VALUE: b[m2-1];
            int r2=(m2==b.length)? Integer.MAX_VALUE: b[m2];
            
            if(l1<=r2 && l2<=r1){
                if((a.length+b.length)%2==0){
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                    
                }else{
                    return (Math.max(l1,l2));
                }
                
            }else if(l2>r1){
                l=m1+1;
            }else{
                h=m1-1;
            }
            
            
            
        }
        return 0.0d;
        
    }
}