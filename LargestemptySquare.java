package medium;
/*
 *
In the provided N*N black and white image, find the largest empty square that does not have black dots.
[Input]
The first line contains the number of test cases T. (1 ≤ T ≤ 10)


The first line of each test case has a size of whole map N. (1 ≤ N ≤ 1,000)

The N number of ‘0’ or ‘1’ will be given as input in N lines. ‘0’ denotes an empty square while ‘1’ represents a black dot.

[Output]

For each test case, on a single line, print the number of test cases “#(TC)“ and the length of one side of the largest empty square.

1        //Total test cases

4        //N image size of the 1st TC

0100     //Image input of the 1st row

1001     //Image input of the 2nd row

1000

0101

 */
import java.util.Scanner;

public class LargestEmptySquare {

	public static int n, max;
	public static int[][] dp;
	public static int[][] matrix;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		for(int i =0;i<t;i++){
			max =0;
			n = in.nextInt();
			matrix = new int[n][n];
			dp = new int[n][n];
			for(int p = 0;p<n;p++){
				String s = in.next();
				for(int q = 0;q<s.length();q++){
					matrix[p][q] = s.charAt(q) -'0';
				}
			}
			//initialize dp first row
			for(int col=0;col<n;col++){
				if(matrix[0][col]==0){
					max= 1;
					dp[0][col] = 1;
				}
				else{
					dp[0][col] = 0;
				}
			}
			
			//initialize dp first col
			for(int row=0;row<n;row++){
				if(matrix[row][0]==0){
					dp[row][0] = 1;
					max =1;
				}
				else{
					dp[row][0] = 0;
				}
			}
			
			for(int row = 1;row<n;row++){
				for(int col = 1; col<n;col++){
					if(matrix[row][col]==1){
						dp[row][col] =0;
					}
					else{
						dp[row][col] = min(dp[row-1][col-1]+1,1+dp[row-1][col],1+dp[row][col-1]);
						if(dp[row][col] > max){
							max = dp[row][col];
						}
					}
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}

		
		in.close();
	}
	
	public static int min(int a, int b, int c){
		int m = a;
		if(a<=b && b<=c){
			m= a;
		}
		if(b<=a && b <=c){
			m= b;
		}
		if(c<=a && c<=b){
			m= c;
		}
		return m;
	}
	public static void displayMatrix(int row, int col){
		for(int i = 0;i<row;i++){
			for(int j = 0;j<col;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
