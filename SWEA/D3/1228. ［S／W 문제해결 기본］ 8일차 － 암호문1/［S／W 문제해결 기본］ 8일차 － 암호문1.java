
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static String command;
	static LinkedList<Integer> origin;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
        	
        	sb.append("#").append(tc).append(" ");
        	
        	N = Integer.parseInt(br.readLine());
        	
        	origin = new LinkedList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < N; i++) {
        		origin.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	M = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < M; i++) { // 명령어 M개
        		String read = st.nextToken();
        		
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());

        		for(int j = 0; j < y; j++) {
        			origin.add(x + j, Integer.parseInt(st.nextToken()));
        		}

        	}
        	
        	for (int i = 0; i < 10; i++) {
        		sb.append(origin.get(i)).append(" ");
        	}
        	sb.append("\n");
        }
        
        wr.write(sb.toString());
        wr.flush();
	}

}
