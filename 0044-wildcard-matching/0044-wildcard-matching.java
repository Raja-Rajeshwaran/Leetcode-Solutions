class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return check(s.length() - 1, p.length() - 1, s, p);
    }

    boolean check(int i, int j, String s, String p) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            ans = check(i - 1, j - 1, s, p);
        } else if (p.charAt(j) == '*') {
            ans = check(i - 1, j, s, p) || check(i, j - 1, s, p);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
