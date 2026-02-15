import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger n = new BigInteger ( a,2);
        BigInteger m = new BigInteger ( b,2);
    

         return n.add(m).toString(2);
    }
}
