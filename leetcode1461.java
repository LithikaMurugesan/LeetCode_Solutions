class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> result = new HashSet <>();
        for(int i=0;i<=s.length()-k;i++){
            result.add(s.substring(i,i+k));
        }
        return result.size() == (1 << k);
    }
}
