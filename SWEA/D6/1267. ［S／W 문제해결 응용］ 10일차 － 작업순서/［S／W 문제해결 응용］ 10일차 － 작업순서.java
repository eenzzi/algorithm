
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int V, E;
	static int[][] graph;
	static int[] num;
	static boolean[] visited;
	static Queue<Integer> q;
	static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new int[V + 1][V + 1];
            num  = new int[V + 1];
            visited = new boolean[V + 1];
            q = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = 1;
				num[b]++;
			}
            
            bfs();
            
            sb.append("\n");
        }
        
        wr.write(sb.toString());
        wr.flush();
	}

    private static void bfs() {
        for (int i = 1; i <= V; i++) {
			if (num[i] == 0) {
				q.offer(i);
				sb.append(i).append(" ");
			}
		}
        
        while(!q.isEmpty()) {
        	int start = q.poll();
        	visited[start] = true;
        	
        	for (int i = 1; i <= V; i++) {
				if (!visited[i] && graph[start][i] == 1) {
	        		num[i]--;
	        		if (num[i] == 0) {
						q.offer(i);
						sb.append(i).append(" ");
					}
				}
			}
        }
	}
}
