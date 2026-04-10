class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> lastTwo = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] indices = lastTwo.get(num);
            
            if (indices == null) {
                lastTwo.put(num, new int[]{-1, i});
            } else {
                
                if (indices[0] != -1) {
                    
                    minDist = Math.min(minDist, 2 * (i - indices[0]));
                }

                indices[0] = indices[1];
                indices[1] = i;
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
