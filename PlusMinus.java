package ds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

	 static void plusMinus(int[] arr) {
	        int positive = 0;
	        int negative = 0;
	        int zeroes = 0;
	        for(int i=0;i<arr.length;i++){
	            if(arr[i]>0){
	                positive++;
	            }
	            else if(arr[i]<0){
	                negative++;
	            }
	            else{
	                zeroes++;
	            }
	        }
	        double fr_pos, fr_neg, fr_ze;
	        fr_pos = (double)positive/arr.length;
	        fr_neg = (double)negative/arr.length;
	        fr_ze = (double)zeroes/arr.length;
	        
	        System.out.printf("%.6f", fr_pos);
	        System.out.println();
	        System.out.printf("%.6f", fr_neg);
	        System.out.println();
	        System.out.printf("%.6f", fr_ze);
	    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
