
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, min;
	static int MAX = 100000;
	static boolean[] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		
		min = Integer.MAX_VALUE;
		visited = new boolean[MAX + 1];
		bfs(N);
		
		System.out.println(min);
	}
	
	private static void bfs(int pos) {

		q.offer(new int[] {pos, 0});
		
		while(!q.isEmpty()) {
			int[] V = q.poll();
			visited[V[0]] = true;
			
			if (V[0] == K) {
				min = Math.min(min, V[1]);
				continue;
			}
			
			int np1 = V[0] * 2;
			int np2 = V[0] + 1;
			int np3 = V[0] - 1;
			
			if (np1 <= MAX  && np1 != 0 && !visited[np1]) {
				q.offer(new int[] {np1, V[1]});
			}
			
			if (np2 <= MAX && !visited[np2]) {
				q.offer(new int[] {np2, V[1] + 1});
			}
			
			if (np3 >= 0 && !visited[np3]) {
				q.offer(new int[] {np3, V[1] + 1});
			}
		}
		
	}
	
}
