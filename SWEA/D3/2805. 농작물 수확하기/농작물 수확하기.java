import java.io.*;
import java.util.Iterator;

public class Solution {

	public static void main(String[] args) throws IOException{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] read = br.readLine().split("");
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(read[j]);
				}
			}
			
			int result = 0;
			
			for (int i = 0; i <= N / 2; i++) {
				for (int j = -i; j <= i; j++) {
					if (i == N / 2) {
						result += arr[i][N / 2 + j];
						continue;
					}
					result += (arr[i][N / 2 + j] + arr[N - 1 - i][N / 2 + j]);
				}
			}
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
		}
	}

}
