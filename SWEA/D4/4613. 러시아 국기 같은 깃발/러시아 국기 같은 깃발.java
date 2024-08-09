import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
public class Solution {
	
	static int N, M, min;
	static char[][] flag;
	static int result;
	static char[] arr;
	static char[] color = {'W', 'B', 'R'};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			result = 0;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String read = br.readLine();
				
				for (int j = 0; j < M; j++) {
					flag[i][j] = read.charAt(j);
					
					if (i == 0 && flag[i][j] != 'W') {
						result += 1;
					} else if (i == N - 1 && flag[i][j] != 'R') {
						result += 1;
					}
				}
			}
			
			arr = new char[N - 2];
			
			array(0, 0);
			
			wr.write("#" + tc + " " + (min + result) + "\n");
			wr.flush();
			
		}

	}
	
	private static void array(int len, int start) {
		if (len == N - 2) {
			int count = paint();
			if (count < min) {
				min = count;
			}
			return;
		}
		
		for (int i = start; i < 3; i++) {
			arr[len] = color[i];
			array(len + 1, i);
		}
	}

	private static int paint() {
		boolean blue = false;
		int count = 0;
		
		for (int i = 0; i < N - 2; i++) {
			if (arr[i] == 'B') {
				blue = true; 
				break;
			}
		}
		
		if (!blue) return Integer.MAX_VALUE;
		
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				if (flag[i][j] != arr[i - 1]) {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
