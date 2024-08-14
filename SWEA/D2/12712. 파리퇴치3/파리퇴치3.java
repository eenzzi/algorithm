
import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[][] graph;
	static int[] dxPlus = {-1, 1, 0, 0};
	static int[] dyPlus = {0, 0, -1, 1};
	static int[] dxCross = {1, 1, -1, -1};
	static int[] dyCross = {1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	graph = new int[N + 2 * M][N + 2 * M];
        	
        	for (int i = M; i < N + M; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = M; j < N + M; j++) {
        			graph[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int max = 0;
        	
        	for (int x = M; x < N + M; x++) {
        		for (int y = M; y < N + M; y++) {
        			int sumPlus = graph[x][y];
        			int sumCross = graph[x][y];
        			
        			for (int i = 1; i < M; i++) {
        				for (int j = 0; j < 4; j++) {
        					int nxPlus = x + dxPlus[j] * i;
        					int nyPlus = y + dyPlus[j] * i;
        					int nxCross = x + dxCross[j] * i;
        					int nyCross = y + dyCross[j] * i;
        					
        					sumPlus += graph[nxPlus][nyPlus];
        					sumCross += graph[nxCross][nyCross];
        				}
        			}
        			int sum = Math.max(sumPlus, sumCross);
        			
        			if (max < sum) {
						max = sum;
					}
        		}
        	}
        	
        	sb.append("#").append(tc).append(" ").append(max).append("\n");
        	
        }
        wr.write(sb.toString());
    	wr.flush();
	}

}
