class Solution {
    public int minimumDeletions(String s) {
        int countb =0;
        int deletion = 0;
        for(char ch : s.toCharArray()){
            if(ch=='b'){
                countb++;
            }else{
                deletion = Math.min(deletion+1, countb);
            }
        }
        return deletion;
    }
}