/* https://www.hackerrank.com/challenges/merging-communities/problem */
/*Disjoint Set */
package ds;
import java.util.Scanner;

public class MergingCommunities {

	public static long[] size;
	public static int[] coms;
	public static int n, q;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		q = in.nextInt();
		coms = new int[n+1];
		size = new long[n+1];
		init();
		for(int i=0;i<q;i++) {
			String query = in.next();
			if(query.equals("M")) {
				merge(in.nextInt(), in.nextInt());
			}
			else {
				System.out.println(size[Root(in.nextInt())]);
			}
		}
		in.close();
	}
	public static void init() {
		for(int i=1;i<=n;i++) {
			coms[i]=i;
            size[i]=1;
		}
	}
	
	public static void merge(int a, int b)
{
    int i = Root(a), j = Root(b);
    	if(i!=j) {
            if(size[i]>=size[j]) {
            	coms[i] = j;
            	size[j] += size[i];
            }
            else {
            	coms[j] = i;
            	size[i] += size[j];
            }
    	}

    
}
	public static int Root(int idx)
{
    int i = idx;
     
    while(i != coms[i]) {
        coms[i] = coms[coms[i]];
        i = coms[i];    
    }

     
    return i;
}
}
