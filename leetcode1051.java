class Solution {
    public int heightChecker(int[] heights) {
       int [] excepeted = Arrays.copyOf(heights,heights.length);
       Arrays.sort(excepeted);
       int count=0;
        for(int i =0;i<heights.length;i++){
            if(heights[i]!=excepeted[i])
            count++;
        }
        return count;
    }
}