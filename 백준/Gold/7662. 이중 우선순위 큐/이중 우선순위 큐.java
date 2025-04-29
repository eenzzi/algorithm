import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int x = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					map.put(x, map.getOrDefault(x, 0) + 1);
					continue;
				}

				if (map.isEmpty()) {
					continue;
				}

				int next;

				if (x == -1) {
					next = map.firstKey();
				} else {
					next = map.lastKey();
				}

				if (map.get(next) == 1) {
					map.remove(next);
				} else {
					map.put(next, map.get(next) - 1);
				}
			}

			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}

}
