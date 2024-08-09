
import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			int[] max = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			max[N - 1] = price[N - 1];
			
			long result = 0;
			
			for (int i = N - 2; i >= 0; i--) {
				if (price[i] < max[i + 1]) {
					max[i] = max[i + 1];
				} else {
					max[i] = price[i];
				}
				result += (max[i] - price[i]);
			
			}

			
			
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
		}

	}

}
