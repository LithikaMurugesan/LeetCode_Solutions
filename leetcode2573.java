class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        for (int i = 0; i < n; i++) {
            word[i] = '?';
        }

        char ch = 'a';
        for (int i = 0; i < n; i++) {
            if (word[i] == '?') {
                if (ch > 'z') return ""; 

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }
        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1) {
                        calc[i][j] = 1;
                    } else {
                        calc[i][j] = 1 + calc[i + 1][j + 1];
                    }
                } else {
                    calc[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != calc[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}
