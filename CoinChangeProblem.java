/* https://www.hackerrank.com/challenges/coin-change/problem */

package ds;

import java.io.*;

import java.util.*;


public class CoinChangeProblem {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {
    	long[] dp = new long[(int)n+1];
    	dp[0] =1;
    	for(int i = 0; i < c.length; i++) {
            for(int j = (int)c[i]; j <= n; j++) {
                dp[j] += dp[j-(int)c[i]];
            }
    }
    	return dp[(int)n];
    }
    
    public static void display(long[][] x) {
    	for(int i = 0;i<x.length;i++) {
    		for(int j =0;j<x[0].length;j++) {
    			System.out.print(x[i][j]+" ");
    		}
    		System.out.println();
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);
        bufferedWriter.close();

        scanner.close();
    }
}
