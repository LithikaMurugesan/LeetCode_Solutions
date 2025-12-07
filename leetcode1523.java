class Solution {
    public int countOdds(int low, int high) {
        int oddup = (high+1)/2;
        int odddown = low/2;
        return  oddup-odddown;
    }
}