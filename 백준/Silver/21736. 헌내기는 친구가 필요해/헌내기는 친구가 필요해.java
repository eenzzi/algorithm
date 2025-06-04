import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, x, y, result;
	static ArrayList<ArrayList<Character>> graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			String read = br.readLine();

			for (int j = 0; j < M; j++) {
				Character now = read.charAt(j);

				graph.get(i).add(now);

				if (now == 'I') {
					x = i;
					y = j;
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		q.offer(new int[] {x, y});
		visited[x][y] = true;
		result = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int cx = now[0];
			int cy = now[1];

			if (graph.get(cx).get(cy) == 'P') {
				result++;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}

				Character next = graph.get(cx).get(cy);

				if (next == 'X') {
					continue;
				}

				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}

		if (result == 0) {
			System.out.println("TT");
			return;
		}

		System.out.println(result);

	}

}
