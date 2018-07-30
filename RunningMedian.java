import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  
   
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static int n ;
    static double[] runningMedian(int[] a) {
       	ArrayList<Integer> temp = new ArrayList<>();
    	double[] result = new double[n];
	    for(int i = 0;i < n; i++){
	    	pq.add(a[i]);
	    	int size = pq.size();
	    	if(size%2==0){
	    		while(pq.size()!= size/2){
	    			temp.add(pq.remove());
	    		}
	    		result[i] = (temp.get(temp.size()-1)+pq.peek())/2.0;
	    		int s = 0;
	    		int tsize = temp.size();
	    		while(tsize  >s){
	    			pq.add(temp.get(s));
	    			s++;
	    		}
	    		temp = new ArrayList<>();
	    	}
	    	else{
	    		while(pq.size() != size/2){
	    			temp.add(pq.remove());
	    		}
	    		result[i] = temp.get(temp.size()-1);
	    		int s = 0;
	    		int tsize = temp.size();
	    		while(tsize > s){
	    			pq.add(temp.get(s));
	    			s++;
	    		}
	    		temp = new ArrayList<>();
	    	}
	    	
	    }
	    return result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[n];

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
