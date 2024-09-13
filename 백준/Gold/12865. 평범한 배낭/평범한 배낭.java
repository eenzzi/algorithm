import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static Item[] items;
	static int[][] dp;
	
	static class Item {
		int weight, value;
		
		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		items = new Item[N + 1];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			items[i] = new Item(w, v);
		}
		
		for (int i = 1; i < N + 1; i++) {
			Item item = items[i];
			
			for (int j = 1; j < K + 1; j++) {
				if (j < item.weight) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int v = dp[i - 1][j - item.weight] + item.value;
					dp[i][j] = Math.max(v, dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
