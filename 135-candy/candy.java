
//wont work as its TC IS O(3N)
// class Solution {
//     public int candy(int[] ratings) {
//         int n=ratings.length;
//         int[] left=new int[n];
//         int[] right=new right[n];
//         int left[0]=1;
//         for(int i=0;i<n-1;i++){
//             if(ratings[i]>ratings[i-1]){
//                 left[i]=left[i-1]+1;

//             }else{
//                 left[i]=1;
//             }

//         }
//         for(i=n-2;i>=0;i--){
//             if(ratings[i]>ratings[i+1]){
//                 right[i]=right[i+1];
//             }else{
//                 right[i]=1;
//             }
//         }
//         int sum=0;
//         for(i=0;i<n-1;i++){
//             sum=sum+Math.max(left[i], right[i]);
//         }
//         return sum;
        
//     }
// }

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while (i < n) {

            // Equal ratings
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // Peak correction
            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }
}
