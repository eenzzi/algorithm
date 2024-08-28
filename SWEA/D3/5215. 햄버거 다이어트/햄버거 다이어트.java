
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, limit, scoreSum, calSum, scoreMax;
	static int[] score, cal;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	StringTokenizer st = new StringTokenizer(br.readLine());

        	N = Integer.parseInt(st.nextToken());
        	limit = Integer.parseInt(st.nextToken());
        	score = new int[N];
        	cal = new int[N];
        	visited = new boolean[N];
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		score[i] = Integer.parseInt(st.nextToken());
        		cal[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	scoreMax = 0;
        	recur(0);
        	
        	sb.append(scoreMax).append("\n");
        }
        
        wr.write(sb.toString());
        wr.flush();
        
	}

	private static void recur(int idx) {
		if (idx >= N || calSum >= limit) {
			return;
		}
		
		scoreSum += score[idx];
		calSum += cal[idx];
		recur(idx + 1);
		if (calSum < limit) {
			scoreMax = Math.max(scoreMax, scoreSum);
		}

		scoreSum -= score[idx];
		calSum -= cal[idx];
		recur(idx + 1);
		scoreMax = Math.max(scoreMax, scoreSum);
		if (calSum < limit) {
			scoreMax = Math.max(scoreMax, scoreSum);
		}
	}
}
