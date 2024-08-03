import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] count = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				count[score]++;
			}
			
			int max = 0;
			int result = 0;
			
			for (int i = 0; i <= 100; i++) {
				if (max <= count[i]) {
					max = count[i];
					result = i;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

}