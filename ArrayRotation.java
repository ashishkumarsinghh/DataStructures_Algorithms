import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayRotation {



    private static int[] a;
    private static final Scanner scanner = new Scanner(System.in);
    public static int abs(int a){
        if(a<0) 
            return -a;
        else return a;
    }
    public static void rotate(){
        int temp = a[0];
        for(int i =0;i+1<a.length;i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = temp;
    }
    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        for(int i =0;i<d;i++){
            rotate();
        }
        for(int i =0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        scanner.close();
    }
}
