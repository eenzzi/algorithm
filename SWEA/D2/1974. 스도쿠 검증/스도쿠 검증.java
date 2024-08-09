import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int N = 9;

	public static void main(String[] args) throws IOException{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		
		for (int tc = 1; tc <= T; tc++) {
			
			for (int i = 0; i < N; i++) {
				int[] count = new int[10];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			if (check(arr)) {
				result = 1;
			}
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
		}
		
	}
	
	static boolean check(int[][] arr) {
		
		for (int i = 0; i < N; i++) {
			int[] count = new int[10];
			for (int j = 0; j < N; j++) {
				if (count[arr[i][j]] != 0) {
					return false;
				}
				count[arr[i][j]]++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int[] count = new int[10];
			for (int j = 0; j < N; j++) {
				if (count[arr[j][i]] != 0) {
					return false;
				}
				count[arr[j][i]]++;
			}
		}
		

		int[][][] count = new int[3][3][10];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int i = r / 3;
				int j = c / 3;
				
				if (count[i][j][arr[r][c]] != 0) {
					return false;
				}
				count[i][j][arr[r][c]]++;
			}
		}
		
		return true;
	}

}
