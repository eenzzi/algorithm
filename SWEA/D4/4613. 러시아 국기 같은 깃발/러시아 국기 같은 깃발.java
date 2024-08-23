import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static char[][] arr;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				String read = br.readLine();
				
				for (int j = 0; j < M; j++) {
					arr[i][j] = read.charAt(j);
				}
			}
			
			int result = Integer.MAX_VALUE;
			
			for (int w = 1; w < N - 1; w++) { // white가 될 수 있는 경계
				for (int b = w + 1; b < N; b++) { //blue가 될 수 있는 경계
					int count = 0;
					
					// 흰색이 아니면 카운트 1 증가
					for (int i = 0; i < w; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'W') {
								count++;
							}
						}
					}
					
					// 파란색 아니면 카운트 1증가
					for (int i = w; i < b; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'B') {
								count++;
							}
						}
					}
					
					for (int i = b; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'R') {
								count++;
							}
						}
					}
					
					result = Math.min(count, result);
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
