class Solution {
    public int maxDistinct(String s) {
       HashSet<Character> num = new HashSet<>();
       for(char ch :s.toCharArray()){
        num.add(ch);
       } 
       return num.size();
    }
}