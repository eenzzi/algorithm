import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H, minDay;
	static int[][][] graph;
	static int[] dx = {-1, 1, 0, 0, 0, 0}; // M
	static int[] dy = {0, 0, -1, 1, 0, 0}; // N
	static int[] dz = {0, 0, 0, 0, -1, 1}; // H
	static Queue<Tomato> q;

	static class Tomato {
		int x, y, z, day;

		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		graph = new int[H][N][M];
		q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < M; k++) {
					int num = Integer.parseInt(st.nextToken());
					graph[i][j][k] = num;

					if (num == 1) {
						q.offer(new Tomato(k, j, i, 0));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Tomato cur = q.poll();

			for (int i = 0; i < 6; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				int nz = dz[i] + cur.z;

				if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
					continue;
				}

				int next = graph[nz][ny][nx];

				if (next == 0) {
					q.offer(new Tomato(nx, ny, nz, cur.day + 1));
					minDay = Math.max(minDay, cur.day + 1);
					graph[nz][ny][nx] = 1;
				}
			}
		}

		boolean clear = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (graph[i][j][k] == 0) {
						clear = false;
					}
				}
			}
		}

		if (clear) {
			System.out.println(minDay);
		} else {
			System.out.println(-1);
		}

	}

}
