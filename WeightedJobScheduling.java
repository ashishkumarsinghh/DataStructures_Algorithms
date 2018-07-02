/*
The first line contains a single integer Tㅡthe number of total test cases. (1 ≤ T ≤ 10)
The first line of each test case contains N, M ㅡ the number of tasks requested and the number of days respectively. (1 ≤ N ≤ 500, 1 ≤ M ≤ 10000)
Throughout N lines, three integers si, ei, ci are given in a space-separated manner. si and ei mean the starting date and the end date of the ith request. ci represents the pay of the requested task. 
(0 ≤ si ≤ ei ≤ 10,000, 0 ≤ ci ≤ 10,000)
There is a freelance interior designer. Since he is a very famous designer, he receives lots of work requests from people. 
However, if the schedules of certain two tasks overlap with one another, he wouldn’t be able to do both of the tasks. In other words, he has to arrange his tasks without a schedule conflict.
Also, when he carries out a task requested, he gets paid for his labor. Your job is to choose a schedule, among possible schedules, that earns the most.  

*/


import java.util.Scanner;

class Job {
	int start, end, profit;
	Job(int s , int e, int p){
		this.start = s;
		this.end = e;
		this.profit = p;
	}

}
public class WeightedJobScheduling {

	public static Job[] jobs;
	public static int n, m;
	public static long[] dp;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int tc = 0;tc<t;tc++){
			n = in.nextInt();
			m = in.nextInt();
			jobs = new Job[n];
			for(int i =0;i<n;i++){
				jobs[i] = new Job(in.nextInt(), in.nextInt(),in.nextInt());
			}
			//sort jobs
			mergeSort(0, n-1);
			//create dp table
			dp = new long[m+1];
			for(int ini = 0;ini<jobs[0].end;ini++){
				dp[ini] = 0;
			}
			dp[jobs[0].end] = jobs[0].profit;
			
			for(int p=1;p<n;p++){
				for(int f = jobs[p-1].end+1; f<jobs[p].end;f++){
					dp[f] = dp[jobs[p-1].end];
				}
				dp[jobs[p].end] = max(jobs[p].profit + dp[jobs[p].start-1], dp[jobs[p-1].end]);

			}
			for(int ini = jobs[n-1].end+1; ini<=m; ini++){
				dp[ini] = dp[jobs[n-1].end];
			}
			System.out.println("#"+(tc+1)+" "+dp[m]);
		}
		in.close();
	}
	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void display(Job[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].end + " ");
		}
		System.out.println();
	}
	public static long max(long a, long b){
		return a>=b?a:b;
	}
	public static void mergeSort(int start, int end){
		if(start<end){
			int mid = start + (end - start)/2;
			mergeSort(start, mid);
			mergeSort(mid+1,end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid , int end){
		int n1 = mid-start+1;
		int n2 = end - mid;
		Job[] left = new Job[n1];
		Job[] right = new Job[n2];
		int k = start;
		for(int i =0;i<n1;i++){
			left[i] = jobs[start+i];
		}
		for(int i =0;i<n2;i++){
			right[i] = jobs[mid+i+1];
		}
		
		int i =0,j=0;
		while(i<n1 && j<n2){
			if(left[i].end <= right[j].end){
				jobs[k] = left[i];
				k++;
				i++;
			}
			else{
				jobs[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i<n1){
			jobs[k] = left[i];
			i++;
			k++;
		}
		while(j<n2){
			jobs[k] = right[j];
			j++;
			k++;
		}
	}
}
