import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Map<String, String> password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		password = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String val = st.nextToken();

			password.put(key, val);
		}



		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String input = br.readLine();

			if (password.containsKey(input)) {
				sb.append(password.get(input)).append("\n");
			}

		}

		System.out.println(sb);
	}
}
