package ds;
/* https://www.hackerrank.com/challenges/diagonal-difference/problem */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DiagonalDifference {


	static int abs(int a) {
		return a<0?-a:a;
	}
	static int diagonalDifference(int[][] arr) {
		/*	00 01 02 03
		 *  10 11 12 13
		 *  20 21 22 23
		 */
		int diag1sum =0;
		int diag2sum = 0;
		for(int i =0;i<arr.length;i++) {
			for(int j =0;j<arr[0].length;j++) {
				if(i==j) {
					diag1sum+=arr[i][j];
				}
				if((i+j)==arr.length-1) {
					diag2sum+=arr[i][j];
				}
			}
		}
		return abs(diag1sum - diag2sum);

    }

    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
