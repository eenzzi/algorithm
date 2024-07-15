import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    st = new StringTokenizer(br.readLine());

	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    graph = new int[N][N];
	    visited = new boolean[N];
	   
	    for (int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken()) - 1;
	        int b = Integer.parseInt(st.nextToken()) - 1;
	        graph[a][b] = graph[b][a] = 1;
	    }
	    
	    int result = 0;

	    for (int i = 0; i < N; i++) {
	    	if (!visited[i]) {
	    		dfs(i);
	    		result++;
	    	}
	    }
	   
	    System.out.println(result);
	}

	private static void dfs(int i) {

		visited[i] = true;
		
		for (int j = 0; j < N; j++) {
			
			if(!visited[j] && graph[i][j] == 1) {
				dfs(j);
			}
		}

	}

}