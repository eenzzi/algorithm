import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int count = 1;
			
			Queue<Integer> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			while (true) {
				int first = q.poll() - count++;
				
				if (first <= 0) {
					q.offer(0);
					break;
				}
				
				if (count == 6) {
					count = 1;
				}
				q.offer(first);
			}
			
			wr.write("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				wr.write(q.poll() + " ");
			}
			wr.write("\n");
			wr.flush();
		}
		

	}

}
