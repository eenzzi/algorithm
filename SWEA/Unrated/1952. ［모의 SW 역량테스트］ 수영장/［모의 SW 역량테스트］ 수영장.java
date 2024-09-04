
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int A, B, C, D, min;
	static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            plan = new int[12];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
            	plan[i] = Integer.parseInt(st.nextToken());
            }
            
            min = Integer.MAX_VALUE;
            dfs(0, 0);
            
            sb.append(min).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
	}

    private static void dfs(int month, int cost) {
    	
    	if (cost >= min) {
			return;
		}
    	
    	if (month > 11) {
    		min = Math.min(cost, D);
			return;
		}
		
    	if (plan[month] == 0) {
			dfs(month + 1, cost);
		} else {
			dfs(month + 1, cost + A * plan[month]);
			dfs(month + 1, cost + B);
			dfs(month + 3, cost + C);
		}
	}
}
