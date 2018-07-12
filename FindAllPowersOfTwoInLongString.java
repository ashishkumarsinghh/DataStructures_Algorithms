package medium;

class TrieNode{
	char data;
	TrieNode[] children;
	boolean isEnd;
	public TrieNode(char d){
		this.data = d;
		this.isEnd = false;
		this.children = new TrieNode[10];
	}
	
	public void insert(String x){
		TrieNode curr = UserSolution.root;
		int i = 0;
		while(i<x.length()){
			int index=x.charAt(i)-'0';
			if(curr.children[index]==null){
				curr.children[index]=new TrieNode(x.charAt(i)); 
			}
			curr = curr.children[index];
			i++;
		}
		curr.isEnd=true;
	}
	
	public int find(char[] x, int k){
		int cnt = 0;
		TrieNode curr = UserSolution.root;
		int i = k;
		while(i<x.length){
			int index=x[i]-'0';
			if(curr.children[index]==null){
				return cnt;
			}
			if(curr.children[index].isEnd){
				cnt++;
			}
			curr = curr.children[index];
			i++;
		}
		return cnt;
	}
}
public class FindAllPowersOfTwoInLongString {

	public static TrieNode root = new TrieNode('~');
	public static boolean processed = false;
	public static String[] powers = new String[801];
	public static void generate(){
		powers[0] = "1";
		for(int i = 1;i<801;i++){
			powers[i] = multiplyBy2(powers[i-1]);
			//System.out.println(powers[i]);
		}
	}
	
	public static String multiplyBy2(String x){
		String res = "";
		int carry = 0;
		for(int i = x.length()-1;i>=0;i--){
			String prod = ""+ Integer.parseInt(""+x.charAt(i))*2;
			if(prod.length()==2){
				res = (Integer.parseInt(""+prod.charAt(1))+carry)+ res;
				carry = Integer.parseInt(""+prod.charAt(0));
			}
			else{
				res =  (Integer.parseInt(""+prod.charAt(0))+carry)+ res;
				carry = 0;

			}
		}
		if(carry!=0){
			return ""+carry+res;
		}
		else{
			return res;	
		}
		
	}
	public static boolean mystrcmp(String x, String y){
		if(x.length()!=y.length()){
			return false;
		}
		else{
			for(int i = 0;i<x.length();i++){
				if(x.charAt(i)!=y.charAt(i)){
					return false;
				}
			}
		}
		return true;
	}
	public static String stringFromCharArr(char[] c,int k){
		String s = "";
		for(int i = k;i<c.length;i++){
			s+=c[i];
		}
		return s;
	}
    public static int solve(char r[]){
    	if(!processed){
    		generate();
    		for(int i = 0;i<801;i++){
    			root.insert(powers[i]);
    		}
    		processed = true;
    	}
    	int count = 0;
    	for(int i = 0;i<r.length;i++){
    		if(r[i]!='0'){
        		count += root.find(r,i);
    		}
    	}
        return count;
    }

}
