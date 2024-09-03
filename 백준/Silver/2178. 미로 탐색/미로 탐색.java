
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] graph, depth;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		depth = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String read = br.readLine();
			for (int j = 0; j < M; j++) {
				int a = read.charAt(j) - '0';
				graph[i][j] = a;
			}
		}
		
		q = new LinkedList<>();
		depth[0][0] = 1;
		
		bfs();
		
		System.out.println(depth[N - 1][M - 1]);
	}
	
	private static void bfs() {
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					depth[nx][ny] = depth[x][y] + 1;
					visited[nx][ny] = true;
				}
			}
		}
	}

}
