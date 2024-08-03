import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int dump = Integer.parseInt(br.readLine());
			int[] height = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i< dump; i++) {
				Arrays.sort(height);
				
				if (height[0] == height[99]) {
					break;
				}
				
				height[0]++;
				height[99]--;
			}
			
			Arrays.sort(height);
			
			int result = height[99] - height[0];
			
			System.out.println("#" + tc + " " + result);
			
		}
	}
}