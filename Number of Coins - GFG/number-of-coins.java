//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution {
    public int minCoins(int coins[], int M, int V) {
        int[][] dp = new int[M + 1][V + 1];

        for (int i = 1; i <= M; i++) {
            dp[i][0] = 0; // no coins needed to make a target of 0
        }

        for (int i = 1; i <= V; i++) {
            dp[0][i] = V + 1; // initialize with a value greater than the maximum possible value of V
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= V; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[M][V] > V ? -1 : dp[M][V];
    }
}
