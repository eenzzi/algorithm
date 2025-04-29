import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static int N;
	static Queue<Node> pq;

	static class Node implements Comparable<Node> {
		int x;

		public Node(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(Node obj) {
			int abs = Math.abs(this.x);
			int objAbs = Math.abs(obj.x);

			if (abs == objAbs) {
				return this.x - obj.x;
			} else if (abs > objAbs) {
				return 1;
			}

			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.offer(new Node(x));
				continue;
			}

			if (!pq.isEmpty()) {
				Node n = pq.poll();
				System.out.println(n.x);
				continue;
			}

			System.out.println(0);

		}

	}

}
