class Solution {
    public boolean isPerfectSquare(int num) {
       int sqr = (int)Math.sqrt(num);
       return sqr*sqr==num;
    }
}