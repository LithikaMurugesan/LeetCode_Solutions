class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while(left <= right){

            long mid = left + (right - left)/2;

            if(canReduce(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes){

        long totalHeight = 0;

        for(int t : workerTimes){

            long low = 0;
            long high = mountainHeight;

            while(low <= high){

                long mid = (low + high)/2;

                long required = (long)t * mid * (mid + 1) / 2;

                if(required <= time){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

            totalHeight += high;

            if(totalHeight >= mountainHeight){
                return true;
            }
        }

        return totalHeight >= mountainHeight;
    }
}
