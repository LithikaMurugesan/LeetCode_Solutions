class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int max = 1;
        for(int i =0;i<n;i++){
            while(nums[i]>(long)nums[left]*k){
                left++;
            }
             max = Math.max(max, i - left + 1);
        }
        return n-max;

    }
}