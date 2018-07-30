
/* https://www.hackerrank.com/challenges/staircase/problem */
import java.util.*;


public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        int hashes = 1;
        
        while(hashes<=n) {
        	int i=0;
        	while(i<n-hashes) {
        		System.out.print(" ");
        		i++;
        	}
        	int k = 0;
        	while(k<hashes) {
        		System.out.print("#");
        		k++;
        	}
        	hashes++;
            System.out.println();
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
