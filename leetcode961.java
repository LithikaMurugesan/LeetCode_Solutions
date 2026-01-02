class Solution {
    public int repeatedNTimes(int[] nums) {
      Set <Integer> seen = new HashSet<>(nums.length / 2 + 1) ;
      for(int i =0;i<nums.length;i++){
        if(!seen.add(nums[i]))
           {
              return nums[i];
           }
      }
      return -1;
      } 
      
    }
