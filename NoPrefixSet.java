/* No Prefix set problem on Hackerrank  Trie Section*/

package ds;
import java.util.Scanner;

class MyTrieNode{
	MyTrieNode[] arr;
	int count;
	boolean isEnd;
	char data;
	MyTrieNode(){
		this.arr = new MyTrieNode[26];
		this.count = 0;
		this.isEnd = false;
		this.data = '\0';
	}
	
	public boolean insert(String s){
		int i = 0;
		MyTrieNode curr = this;
		while(i<s.length()){
			if(curr.arr[s.charAt(i)-97] == null){
				MyTrieNode nn = new MyTrieNode();
				nn.data = s.charAt(i);

				curr.arr[s.charAt(i)-97] = nn;
				curr = curr.arr[s.charAt(i)-97];
			}
			else{
				curr = curr.arr[s.charAt(i)-97];
				if(curr.isEnd) {
					curr.count++;
				}
				if(curr.count >=1) {
					 return false;
				}
			}
			
			i++;
		}
		curr.isEnd = true;
		return true;
	}

}
public class NoPrefixSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean flag = false;
		MyTrieNode mtn = new MyTrieNode();
		for(int i =0;i<n;i++) {
			String s = in.next();
			if(!mtn.insert(s)) {
				System.out.println("BAD SET");
				System.out.println(s);
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("GOOD SET");
		}
	}
}
