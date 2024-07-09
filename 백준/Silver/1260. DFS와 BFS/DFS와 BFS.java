import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 클래스 이름을 Main으로 변경
	
	static int N, M, V;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		queue = new LinkedList<>();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		}
		
		dfs(V);
		visit = new boolean[N + 1];
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int V) {
		
		visit[V] = true;
		sb.append(V).append(" ");
		
		for(int i = 1; i <= N; i++) {
			if (map[V][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}	
	}
	
	private static void bfs(int V) {
		
		visit[V] = true;
		queue.add(V);
		
		while(!queue.isEmpty()) {
			V = queue.poll();
			sb.append(V).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(map[i][V] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
