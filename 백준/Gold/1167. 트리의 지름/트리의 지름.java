
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static int V, max, leaf;
	static ArrayList<int[]>[] graph;
	static boolean[] visited;
//	static ArrayList<Integer> leaf;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
//		leaf = new ArrayList<>();
		
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for (int i = 1; i <= V; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int count = 0;
			
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) {
					break;
				}
				int distance = Integer.parseInt(st.nextToken());
				graph[a].add(new int[] {b, distance});
				graph[b].add(new int[] {a, distance});
				
				count++;
			}
			
//			if (count == 1) {
//				leaf.add(i);
//			}
		}
		
		visited = new boolean[V + 1];
		max = 0;
		dfs(1, 0);
		
		visited = new boolean[V + 1];
		dfs(leaf, 0);
		
//		for(int i = 0; i < leaf.size(); i++) {
//			visited = new boolean[V + 1];
//			dfs(leaf.get(i), 0);
//		}
		
		System.out.println(max);
		
	}
	
	private static void dfs(int node, int r) {
		
		if (max < r) {
			max = r;
			leaf = node;
		}
				
		visited[node] = true;
		
		for (int[] edge : graph[node]) {
			int nextNode = edge[0];
			int distance = edge[1];
			if (!visited[nextNode]) {
				dfs(nextNode, r + distance);
				visited[nextNode] = true;
			}
		}
		
		
	}

}
