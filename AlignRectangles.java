/* Aligning the rectangles */

/*
Aligning the rectangles

You are given
rectangles each with length and breadth

. Now you have to arrange them in non-decreasing order of their lengths. If length of two rectangles is same then the one with the largest area should be placed first. Print the final arrangement of the rectangles.

Input
First line contains an integer
as input denoting total number of rectangles.
Next

lines contain two space separated integers each denoting length and breadth of the subsequent rectangles.

Output
In the output you need to print

lines where each line contains the length and breadth of the rectangle as they would look in the final arrangement according to the conditions given above.

Constraints

Sample Input

3
4 2
1 2
2 3

Sample Output

1 2
2 3
4 2



*/


package hc;

import java.util.Arrays;
import java.util.Scanner;

class Rectangle implements Comparable<Rectangle>{
	int length, breadth;
	Rectangle(int l, int b){
		this.length = l;
		this.breadth = b;
	}
	@Override
	public int compareTo(Rectangle o) {
		if(this.length - o.length == 0) {
			return this.breadth - o.breadth;
		}
		else {
			return this.length - o.length;
		}
	}
}

public class TestClass {

	public static Rectangle[] rects;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		rects = new Rectangle[n];
		for(int i = 0; i<n; i++) {
			int l = in.nextInt();
			int b = in.nextInt();
			rects[i] = new Rectangle(l, b);
		}
		
		Arrays.sort(rects);
		for(int i = 0; i < n; i++) {
			System.out.println(rects[i].length +" "+ rects[i].breadth);
		}
		in.close();
	}
}
