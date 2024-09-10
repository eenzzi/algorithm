import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N, M;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/평4/2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String[] str1 = br.readLine().trim().split(" ");
		N = Integer.parseInt(str1[0]);
		M = Integer.parseInt(str1[1]);
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().trim().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs();
		System.out.println(arr[N - 1][M - 1]);

	}// end main

	private static void bfs() {
		Queue<Integer> qR = new LinkedList<>();
		Queue<Integer> qC = new LinkedList<>();

		qR.offer(0);
		qC.offer(0);
		visited[0][0] = true;

		while (!qR.isEmpty()) {
			int r = qR.poll();
			int c = qC.poll();

			for (int k = 0; k < 4; k++) {
				int flagR = r + dr[k];
				int flagC = c + dc[k];

				if (flagR >= 0 && flagR < N && flagC >= 0 && flagC < M && arr[flagR][flagC] == 1
						&& !visited[flagR][flagC]) {
					qR.offer(flagR);
					qC.offer(flagC);
					visited[flagR][flagC] = true;
					arr[flagR][flagC] = arr[r][c] + 1;
				}
			}
		}
	}

}