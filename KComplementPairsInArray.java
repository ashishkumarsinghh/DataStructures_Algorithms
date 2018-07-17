package medium;

import java.util.HashMap;

public class Codility {

	public static void main(String[] args){
		int[] ar = {5,3,1,1,8, -2};
		System.out.println(solve(ar, 6));
	}


public static int solve(int[] arr, int k){
	int count = 0;
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	for(int i =0; i<arr.length;i++){
		if(hm.containsKey(arr[i])){
			int frq = hm.get(arr[i]);
			hm.put(arr[i] , frq+1);
		}
		else{
			hm.put(arr[i], 1);
		}
	}
	for(int i =0; i<arr.length;i++){

		if(hm.containsKey(k-arr[i])){
			count += hm.get(k-arr[i]);
		}
	}
	return count;
}
}
