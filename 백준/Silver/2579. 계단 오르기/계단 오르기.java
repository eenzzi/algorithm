import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, max;
	static int[] score, stair;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		max = 0;
		score = new int[301];
		stair = new int[301];
		
		for (int i = 0; i < N; i++) {
		
			stair[i] = Integer.parseInt(br.readLine());	
		}
		
		score[0] = stair[0];
		score[1] = stair[0] + stair[1];
		score[2] = Math.max(stair[0], stair[1]) + stair[2];
		
		System.out.println(max());
		
	}
	
	private static int max() {
		
		if (N < 3) {
			return score[N - 1];
		}
		
		for (int i = 3; i < N; i++) {
			score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
		}
		
		return score[N - 1];
	}

	
	
}