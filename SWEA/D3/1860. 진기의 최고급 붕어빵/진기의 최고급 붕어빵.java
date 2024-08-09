import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] client = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				client[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(client);
			int count = 0;
			String result = "Possible";
			
			for (int i = 0; i < N; i++) {
				int time = client[i];
				
				if ((time / M) * K < i + 1) {
					result = "Impossible";
				}
			}
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
		}

	}

}
