class Fancy {

    private static final long MOD = 1000000007;
    private List<Long> seq;
    private long mul;
    private long add;

    public Fancy() {
        seq = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    public void append(int val) {
        long v = (val - add + MOD) % MOD;
        v = (v * modInverse(mul)) % MOD;
        seq.add(v);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size())
            return -1;
        long value = (seq.get(idx) * mul + add) % MOD;
        return (int) value;
    }
}
