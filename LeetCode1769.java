class Solution {
    public int[] minOperations(String boxes) {
        int [] res = new int[boxes.length()];
        for(int current = 0;current<boxes.length();current++){
        if(boxes.charAt(current)=='1'){
            for(int i=0;i<boxes.length();i++){
                res[i] +=Math.abs(i-current);
            }
        }
        }
        return res;
    }
}