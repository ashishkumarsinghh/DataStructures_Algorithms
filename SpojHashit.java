//Hashit spoj problem
// https://www.spoj.com/problems/HASHIT/
//2 parts Solution class and UserSolution class, Main is Solution

package SolvingClub;

class UserSolution {
	public static int keys;
	public static String[] hash_table;

	UserSolution() {
		this.keys = 0;
		this.hash_table = new String[102];
	}

	public static boolean strcmp(String x, String y) {
		int i = 0;
		boolean flag = true;
		while(true){
			if(x.length()==0 && y.length()==0){
				break;
			}
			else if(x.length() != y.length()){
				flag = false;
				break;
			}
			else if(i==x.length()-1){
				if(x.charAt(i)==y.charAt(i))
					break;
				else{
					flag = false;
					break;
				}
			}
			else if(x.charAt(i)!=y.charAt(i)){
				flag = false;
				break;
			}
			i++;
			
		}
		return flag;
	}

	void processThis(String X, int len) {
		if (strcmp("" + X.charAt(0) + X.charAt(1) + X.charAt(2), "ADD")) {
			String s = "";
			for (int i = 4; i < len; i++) {
				s += X.charAt(i);
			}
			put(s);
		}
		if (strcmp("" + X.charAt(0) + X.charAt(1) + X.charAt(2), "DEL")) {
			String s = "";
			for (int i = 4; i < len; i++) {
				s += X.charAt(i);
			}
			remove(s);
		}
	}

	int storeOutput(String K[]) {
		int k = 0;
		for (int i = 0; i < 102; i++) {
			if (hash_table[i] != null) {
				K[k] = i + ":" + hash_table[i];
				k++;
			}
		}
		return k;
	}

	// hash function
	public static int hash(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += ((i + 1) * ((int) s.charAt(i)));
		}
		return (int) (sum * 19) % 101;
	}

	// check if string exists in hash table and return key, else -1 if not found
	public static int isExists(String s) {
		int key = hash(s);
		if (hash_table[key] != null && strcmp(hash_table[key], s))
			return key;
		else {
			for (int j = 1; j <= 19; j++) {
				if (hash_table[(key + j * j + 23 * j) % 101] != null
						&& strcmp(hash_table[(key + j * j + 23 * j) % 101], s)) {
					return (key + j * j + 23 * j) % 101;
				}
			}
		}
		return -1;
	}

	// insert in hash table
	public static boolean put(String s) {
		// return true if inserted, return false otherwise.
		// Insert only if not present and if empty location
		// found in less than or equal to 20 times collision resolution
		if (isExists(s) == -1) {
			int key = hash(s);
			if (hash_table[key] == null) {
				hash_table[key] = s;
				keys++;
				return true;
			} else {
				for (int j = 1; j <= 19; j++) {
					if (hash_table[(key + j * j + 23 * j) % 101] == null) {
						hash_table[(key + j * j + 23 * j) % 101] = s;
						keys++;
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean remove(String s) {
		// delete a key from the table (without moving the others),
		// by marking the position in table as empty (ignore non-existing keys
		// in the table)

			int key = hash(s);
			if (hash_table[key] != null && strcmp(hash_table[key], s)) {
				hash_table[key] = null;
				keys--;
				return true;
			} else {
				for (int j = 1; j <= 19; j++) {
					if (hash_table[(key + j * j + 23 * j) % 101] != null
							&& strcmp(hash_table[(key + j * j + 23 * j) % 101], s)) {
						hash_table[(key + j * j + 23 * j) % 101] = null;
						keys--;
						return true;
					}
				}
			}	
		

		return false;
	}
}

package SolvingClub;
import java.util.Scanner;

class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T > 0)
		{
			UserSolution res = new UserSolution();
			String S[] = new String[102];
			T--;
			int n = sc.nextInt();
			sc.nextLine();
			while(n > 0)
			{
				n--;
				String s = sc.nextLine();
				res.processThis(s, s.length());
			}
			int count = res.storeOutput(S);
			System.out.println(count);
			for(int i = 0; i < count; ++i)
			{
				System.out.println(S[i]);
			}
		}
	}
}
