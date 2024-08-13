
import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;
public class Solution {
	
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	A = new int[N];
        	B = new int[M];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		A[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < M; i++) {
        		B[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int max = 0;
        	for (int i = 0; i < Math.abs(M - N) + 1; i++) {
        		int num = 0;
        		
        		if (N < M) {
        			for (int j = 0; j < N; j++) {
            			num += (A[j] * B[j + i]);
            		}	
				} else {
					for (int j = 0; j < M; j++) {
	        			num += (A[j + i] * B[j]);
	        		}
				}
        		
        		
        		if (num > max) {
					max = num;
				}
        	}
        	
        	wr.write("#" + tc + " " + max + "\n");
        	wr.flush();
        }

	}

}
