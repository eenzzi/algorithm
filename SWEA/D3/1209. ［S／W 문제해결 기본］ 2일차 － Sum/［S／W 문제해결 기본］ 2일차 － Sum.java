import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			int max = 0;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 행 최댓값 찾기
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				
				if (max < sum) {
					max = sum;
				}
			}
			
			// 열 최댓
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				
				if (max < sum) {
					max = sum;
				}
			}
			
			// 대각선
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][i];
			}
			
			if (max < sum) {
				max = sum;
			}
			
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][100 - i - 1];
			}
			
			if (max < sum) {
				max = sum;
			}
			
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
			
			wr.write("#" + tc + " " + max + "\n");
			wr.flush();
		}

	}

}
