package medium;

import java.util.Scanner;

public class InversionCounting {

	public static int[] ar;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++ ){
			int n = in.nextInt();
			ar = new int[n];
			for(int j = 0; j < n; j++){
				ar[j] = in.nextInt();
			}
			System.out.println("#" + (i+1) + " "+ 	mergeSort(0, ar.length-1));
		}
		in.close();
	}
	
	public static long mergeSort(int start, int end){
		long inv_count =0;
		if(start<end){
			int mid = start + (end -start)/2;
			inv_count=mergeSort(start, mid);
			inv_count+=mergeSort(mid+1, end);
			inv_count+=merge(start, mid, end);
		}
		return inv_count;
	}
	
	public static void display(int [] ar){
		for(int i = 0;i<ar.length;i++){
			System.out.print(ar[i]+" ");
		}
	}
	public static long merge(int start, int mid, int end){
		int n1 = mid - start +1;
		int n2 = end - mid;
		long inv_count  = 0;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int p =0;p<n1;p++){
			left[p] = ar[start+p];
		}
		for(int p= 0; p<n2;p++){
			right[p] = ar[mid+p+1];
		}
		
		int i = 0, j = 0, k = start;
		
		while(i<n1 && j<n2){
			if(left[i] <= right[j]){
				
				ar[k] = left[i];
				k++; i++;
			}
			else{
				ar[k] = right[j];
				k++; j++;
				inv_count+=(n1-i);
			}
		}
		
		while(i < n1){
			ar[k] = left[i];
			i++;k++;
		}
		while(j <n2){
			ar[k] = right[j];
			j++;k++;
		}
		return inv_count;
	}
	
}
