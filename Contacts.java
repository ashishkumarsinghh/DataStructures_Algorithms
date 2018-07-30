//Trie Problem on Hackerrank

//https://www.hackerrank.com/challenges/ctci-contacts/problem

package SolvingClub;
import java.util.Scanner;

class TrieNode{
	TrieNode[] arr;
	int count;
	boolean isEnd;
	char data;
	TrieNode(){
		this.arr = new TrieNode[26];
		this.count = 0;
		this.isEnd = false;
		this.data = '\0';
	}
	
	public void insert(String s){
		int i = 0;
		TrieNode curr = this;
		while(i<s.length()){
			if(curr.arr[s.charAt(i)-97] == null){
				TrieNode nn = new TrieNode();
				nn.data = s.charAt(i);
				nn.count++;
				curr.arr[s.charAt(i)-97] = nn;
				curr = curr.arr[s.charAt(i)-97];
			}
			else{
				curr = curr.arr[s.charAt(i)-97];
				curr.count++;
			}
			curr.isEnd = true;
			i++;
		}
	}
	
	public  int find(String s){
		int i = 0;
		TrieNode curr = this;
		if(s.length()==0) return 0;
		
		while(i<s.length()){
			if(curr.arr[s.charAt(i)-97] == null) 
				return 0;
			curr = curr.arr[s.charAt(i)-97];
			i++;
		}
		return curr.count;
	}
}
public class Contacts {

	public static void main(String args[]){
		TrieNode tn = new TrieNode();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            String q = in.next();
            String val = in.next();
            if(q.equals("add")){
            	tn.insert(val);
            }
            else{
            	System.out.println(tn.find(val));
            }
        }

	}
}
