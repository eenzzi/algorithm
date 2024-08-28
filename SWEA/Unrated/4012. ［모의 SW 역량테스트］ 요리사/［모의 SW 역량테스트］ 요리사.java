
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] arr;
	static int[] comb;
	static ArrayList<Integer> score, diffScore;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");

        	N = Integer.parseInt(br.readLine());
        	arr = new int[N][N];
        	score = new ArrayList<>();
        	diffScore = new ArrayList<>();
        	comb = new int[N / 2];

        	for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	combRecur(0, 0);
        	for (int i = 0; i < score.size() / 2; i++) {
        		diffScore.add(Math.abs(score.get(i) - score.get(score.size() - 1 - i)));
        	}
        	Collections.sort(diffScore);

        	sb.append(diffScore.get(0)).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
	}
	
	private static void combRecur(int idx, int sidx) {
 		if (sidx >= N / 2) {
 			int sum = 0;
 			for (int i = 0; i < N / 2; i++) {
 				for (int j = i + 1; j < N / 2; j++) {
 					sum += (arr[comb[i]][comb[j]] + arr[comb[j]][comb[i]]);
 				}
 			}
			score.add(sum);
			return;
		}
		
		for (int i = idx; i <= N - (N / 2) + sidx; i++) {
			comb[sidx] = i;
			combRecur(i + 1, sidx + 1);
		}

	}

}
