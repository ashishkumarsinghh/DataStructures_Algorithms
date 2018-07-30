
/* Maximum element problem on Hackerrank */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Stack{
    int max, tempmax;
    int top;
    int[] arr;
    Stack(){
        this.top = -1;
        this.arr = new int[100000];
        this.max = 0;
        this.tempmax =0;
    }
    void delete(){
       if(max == this.arr[top]){
           int tempmax = 0;
           for(int i=0;i<this.top;i++){
               if(this.arr[i] > tempmax){
                   tempmax = this.arr[i];
               }
           }
           max = tempmax;
       }
        this.top -= 1;
    }
    void push(int item){
        top+=1;
        arr[top] = item;
        if(item > max){
            max = item;
        }
    }
    
    int maxItem(){
        return max;
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack s = new Stack();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int q = in.nextInt();
            if(q==1){
                int item = in.nextInt();
                s.push(item);
            }
            else if(q ==2){
                s.delete();
            }
            else if(q==3){
                System.out.println(s.maxItem());
            }
        }
        
    }
}
