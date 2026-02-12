class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        for(int i=0;i<n;i++){
            HashMap<Character,Integer>freq = new HashMap<>();
            for(int j =i;j<n;j++){
                char c = s.charAt(j);
                freq.put(c,freq.getOrDefault(c,0)+1);
                if(isBalanced(freq)){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    private boolean isBalanced(HashMap<Character, Integer>freq){
    int target = -1;
    for(int count :freq.values()){
        if(target==-1){
            target = count;
        }else if(count!=target){
            return false;
        }
    }
    return target!=-1;
    }
}