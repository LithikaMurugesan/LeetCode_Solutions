class Solution {
    public int numTrees(int n) {
        int total = 0;
      if(n<=1)
      return 1;
      for(int i =1;i<=n;i++){
        int left = numTrees(i-1);
        int right = numTrees(n-i);
        total =total+ left*right;
         
      }
   return total;
    }
}