import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(1, i, j, arr[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	private static void dfs(int depth, int x, int y, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (visited[nx][ny]) {
				continue;
			}

			if (depth == 2) {
				visited[nx][ny] = true;
				dfs(depth + 1, x, y, arr[nx][ny] + sum);
				visited[nx][ny] = false;
			}

			visited[nx][ny] = true;
			dfs(depth + 1, nx, ny, arr[nx][ny] + sum);
			visited[nx][ny] = false;
		}
	}
}
