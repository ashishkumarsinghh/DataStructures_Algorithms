
import java.util.Scanner;

class STNode {
	int data;
	int leftIndex;
	int rightIndex;
	STNode left, right;

	STNode() {
		this.data = 0;
		this.leftIndex = 0;
		this.rightIndex = 0;
		this.left = null;
		this.right = null;
	}
}

public class SegmentTree {

	public static int yourFunction(int a, int b) {
		return a > b ? a : b;
	}

	public static STNode constructST(int[] ar, int begin, int end) {
		if (begin == end) {
			STNode node = new STNode();
			node.leftIndex = begin;
			node.rightIndex = end;
			node.data = ar[begin];
			return node;
		} else {
			int mid = begin + (end - begin) / 2;
			STNode leftNode = constructST(ar, begin, mid);
			STNode rightNode = constructST(ar, mid + 1, end);
			STNode node = new STNode();
			node.left = leftNode;
			node.right = rightNode;
			node.leftIndex = leftNode.leftIndex;
			node.rightIndex = rightNode.rightIndex;
			node.data = yourFunction(leftNode.data, rightNode.data);
			return node;
		}
	}

	public static int queryResult(STNode root, int begin, int end) {
		// 3 cases : 1. query interval completely covers the node 2. Partial
		// overlap 3. completely outside.
		if (root == null)
			return Integer.MIN_VALUE;
		
		// 1st case
		if (begin <= root.leftIndex && end >= root.rightIndex) {
			return root.data;
		}
		// 2nd case no overlap
		if ((begin > root.rightIndex && end < root.leftIndex))
			return Integer.MIN_VALUE;

		return yourFunction(queryResult(root.left, begin, end), queryResult(root.right, begin, end));

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		STNode root = constructST(arr, 0, arr.length - 1);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(queryResult(root, a, b));
		}
		in.close();
	}

	public static int nextPowerOf2(int n) {
		int i = 2;
		while (i < n) {
			i *= 2;
		}
		return n;
	}
}
