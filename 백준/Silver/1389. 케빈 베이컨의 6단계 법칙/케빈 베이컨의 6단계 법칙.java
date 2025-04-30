import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min, ans;
	static ArrayList<ArrayList<Integer>> list;

	static class Node {
		int x, idx;

		public Node(int x, int idx) {
			this.x = x;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) {
			int sum = bfs(i);
			if (sum < min) {
				min = sum;
				ans = i;
			}
		}

		System.out.println(ans);
	}

	private static int bfs(int x) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int sum = 0;

		q.offer(new Node(x, 0));

		visited[x] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			sum += node.idx;

			for (int next : list.get(node.x)) {
				if (visited[next]) {
					continue;
				}

				q.offer(new Node(next, node.idx + 1));
				visited[next] = true;
			}
		}

		return sum;
	}

}
