package medium;

import java.util.Scanner;

class GraphEdge {
	int cost;
	int src, dest;

	GraphEdge(int src, int dest, int cost) {
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
}

public class BuildingExpressWays {

	public static int[] parent;
	public static boolean[] visited;
	public static GraphEdge[] edges;
	public static long total;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			total = 0;
			int n = in.nextInt();
			parent = new int[n + 1];
			visited = new boolean[n + 1];

			for (int p = 0; p <= n; p++) {
				parent[p] = p;
			}
			int ce = in.nextInt();
			edges = new GraphEdge[ce];
			for (int j = 0; j < ce; j++) {
				edges[j] = new GraphEdge(in.nextInt(), in.nextInt(),
						in.nextInt());
			}
			mergeSort(0, edges.length - 1);
			for (int p = 0; p < ce; p++) {
				if ((find(edges[p].src) != find(edges[p].dest))) {
					union(edges[p].src, edges[p].dest);
					visited[edges[p].src] = true;
					visited[edges[p].dest] = true;
					total += edges[p].cost;
				}
			}
			System.out.println("#" + (i+1) + " " + total);
		}
		in.close();
	}

	public static int find(int i) {
		while (parent[i] != i) {
			i = parent[i];
			parent[i] = parent[parent[i]];
		}
		return i;
	}

	public static void union(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if (pi != pj) {
			if(pi<pj){
				parent[pi] = pj;
			}
			else{
				parent[pj] = pi;
			}
		}
	}

	public static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	public static void merge(int start, int mid, int end) {
		int i = 0, j = 0, k = start;
		int n1 = mid - start + 1;
		int n2 = end - mid;
		GraphEdge[] left = new GraphEdge[n1];
		GraphEdge[] right = new GraphEdge[n2];

		for (int p = 0; p < n1; p++) {
			left[p] = edges[start + p];
		}
		for (int p = 0; p < n2; p++) {
			right[p] = edges[mid + p + 1];
		}

		while (i < n1 && j < n2) {
			if (left[i].cost <= right[j].cost) {

				edges[k] = left[i];
				k++;
				i++;
			} else {
				edges[k] = right[j];
				k++;
				j++;
			}
		}

		while (i < n1) {
			edges[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			edges[k] = right[j];
			j++;
			k++;
		}

	}
}
