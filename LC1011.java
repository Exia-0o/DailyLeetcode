class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int start = -1;
        int end = 0;
        for(int w : weights){
            start = Math.max(start,w);
            end += w;
        }
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(isPossible(weights, mid, D)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[]weights, int value, int k){
        int sum = 0;
        int count = 1;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if (sum > value){
                sum = weights[i];
                count++;
            }
        }
        return count > k ? false : true; 
    }
}
