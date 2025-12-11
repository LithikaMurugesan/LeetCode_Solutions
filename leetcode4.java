class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m+n];
        System.arraycopy(nums1,0,merge,0,m);
        System.arraycopy(nums2,0,merge,m,n);
         Arrays.sort(merge);
        int length = merge.length;
        if(length%2==1){
            return merge[length / 2];
        }
        else{
               return (merge[length / 2] + merge[length / 2 - 1]) / 2.0;
        }

    }
}