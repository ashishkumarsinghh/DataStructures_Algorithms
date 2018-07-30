package hc;

import java.io.*;
import java.util.*;

public class DisjointSetBipartite {

	public static int n;
	public static int[] parent, size;
    static int[] componentsInGraph(int[][] gb) {
    
    	parent = new int[2*n+1];
    	size = new int[2*n+1];
    	int[] result = new int[2];
    	for(int i = 1; i <= 2*n; i++) {
    		parent[i] = i;
    		size[i] =1;
    	}
    	for(int i = 0; i < n; i++) {
    		merge(gb[i][0], gb[i][1]);
    	}
    	int max = 1;
    	int maxid = 1;
    	for(int i = 1; i <=2*n; i++) {
    		if(size[i] > max) {
    			max = size[i];
    			maxid = i;
    		}
    	}
    	int min = max;
    	for(int i = 1; i <= 2*n; i++) {
    		if(size[i] < min && size[i] != 1 && root(i) != root(maxid)) {
    			min = size[i];
    		}
    	}
    	
    	result[0] = min;
    	result[1] = max;
    	return result;
    }
    public static void merge(int a, int b) {
        int pa = root(a);
        int pb = root(b);
        if(pa!=pb) {
            if(size[pa]>=size[pb]) {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            else {
                parent[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }
    
    public static int root(int i) {
        while(i != parent[i]) {
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }
  
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
