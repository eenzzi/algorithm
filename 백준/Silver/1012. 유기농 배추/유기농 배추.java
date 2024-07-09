import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, M, N, K, count;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
//	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			
			map = new int[M][N];
			visit = new boolean[M][N];
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[X][Y] = 1;
				
			}
			
			for(int x = 0; x < M; x++) {
				for(int y = 0; y < N; y++) {
					if(map[x][y] == 1 && !visit[x][y]) {
						dfs(x, y);
						count++;
						
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	private static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if(map[cx][cy] == 1 && !visit[cx][cy]) {
					dfs(cx, cy);
				}
			}
		}
		
		
	}
	
	
}