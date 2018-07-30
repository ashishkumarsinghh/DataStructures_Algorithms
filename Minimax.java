package ds;

import java.util.*;


public class Minimax {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long min=Long.MAX_VALUE, max=0;
    	long[] acc = new long[arr.length];
    	acc[0] = arr[0];
    	for(int i =1;i<arr.length;i++) {
    		acc[i] = acc[i-1]+arr[i];
    	}
    	for(int i =0;i<arr.length;i++) {
    		if(acc[arr.length-1]-arr[i]>max) {
    			max = acc[arr.length-1]-arr[i];
    		}
    		if(acc[arr.length-1]-arr[i]<min) {
    			min = acc[arr.length-1]-arr[i];
    		}    	
    	}
    	System.out.println(min + " "+ max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
