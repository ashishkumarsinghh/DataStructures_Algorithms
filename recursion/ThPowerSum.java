/* https://www.hackerrank.com/challenges/the-power-sum/problem */
import java.util.Scanner;
class ThPowerSum{
    public static int result = 0, x, n;
    public static int[] nn = new int[1001];
    public static boolean[] visited = new boolean[1001];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        n = in.nextInt();
        for(int i=0;i<1001;i++){
            nn[i]=i;
        }
        ways(0,0, visited);
        System.out.println(result);
        in.close();
    }

    public static void ways(int sum, int next, boolean[] visited){
        if( next < x && sum == x){
            result += 1;
        }
        else if(next > x || sum > x)
            return;
        else{
            ways(sum, next+1,visited);
            visited[next] = true;
            ways(sum + power(nn[next],n), next+1, visited);
            visited[next] = false;
        }

    }

    public static int power(int base, int power){
        int res = 1;
        for(int i = 0; i < power; i++){
            base *= base;
        }
        return res;
    }

}