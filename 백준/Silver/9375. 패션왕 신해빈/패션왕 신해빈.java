import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int T, N, ans;
	static Map<String, Integer> map;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new HashMap<>();
			list = new ArrayList<>();
			ans = 1;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				st.nextToken();
				String type = st.nextToken();

				if (map.containsKey(type)) {
					Integer val = map.get(type);
					map.replace(type, val + 1);
				} else {
					map.put(type, 1);
				}
			}

			for (int count : map.values()) {
				ans *= (count + 1);
			}

			System.out.println(ans - 1);
		}

	}
}
