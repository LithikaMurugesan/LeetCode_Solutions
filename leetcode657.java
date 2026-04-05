class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i =0 ;i<moves.length();i++){
            char mov = moves.charAt(i);
            if(mov=='U') y++;
            else if(mov=='D')y--;
             else if(mov=='R')x++;
            else if(mov=='L')x--;
        }
        return x==0 && y==0;
    }
}
