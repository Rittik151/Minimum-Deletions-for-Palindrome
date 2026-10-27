import java.util.*;

class Minimum_Deletions_for_Palindrome {
    static int minDeletions(String s) {
        // code here
        int n=s.length();
        int m=s.length();
        String s1="";
        for(int i=s.length()-1;i>=0;i--){
            s1+=s.charAt(i);
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return n-dp[n][m];
    }
}