
import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M;
	static String command;
	static LinkedList<Integer> origin;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
        	
        	sb.append("#").append(tc).append(" ");
        	
        	N = Integer.parseInt(br.readLine());
        	
        	origin = new LinkedList<>();
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < N; i++) {
        		origin.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	M = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < M; i++) {
        		String read = st.nextToken();
        		
        		if (read.equals("I")) {
					insert();
					continue;
				} else if (read.equals("D")) {
					delete();
					continue;
				} else {
					addNum();
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
	
	private static void insert() {
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		for(int j = 0; j < y; j++) {
			origin.add(x + j, Integer.parseInt(st.nextToken()));
		}
	}
	
	private static void delete() {
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		for(int j = 0; j < y; j++) {
			origin.remove(x);
		}
	}
	
	private static void addNum() {
		int y = Integer.parseInt(st.nextToken());
		for(int j = 0; j < y; j++) {
			origin.add(Integer.parseInt(st.nextToken()));
		}
	}

}
