import java.util.Arrays;

public class leet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,4,5,6};
        s.wiggleSort(nums);

        for (int x : nums) System.out.print(x + " ");
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int [] sorted = nums.clone();
        Arrays.sort(sorted);
        int mid = (n-1)/2;
        int end = n-1;
        int i = mid;
        int j = end;
        for(int k = 0;k<n;k++){
            if(k%2==0){
                nums[k] = sorted[i--];
            }
            else{
                nums[k] = sorted[j--];
            }
        }
    }
}