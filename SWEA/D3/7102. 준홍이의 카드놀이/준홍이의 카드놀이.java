import java.io.*;
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
			
			int idx = Math.abs(N - M) + 1;
			
			wr.write("#" + tc + " ");
			
			for (int i = 1; i <= idx; i++) {
				wr.write(Math.min(N, M) + i + " ");
			}
			
			wr.write("\n");
			wr.flush();
		}
	}

}
