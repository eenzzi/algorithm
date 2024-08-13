
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	int distance = 0;
        	int speed = 0;
        	
        	for (int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int command = Integer.parseInt(st.nextToken());
        		
        		if (command == 1) {
					speed += Integer.parseInt(st.nextToken());
				} else if (command == 2) {
					int dec = Integer.parseInt(st.nextToken());
					if (dec > speed) {
						speed = 0;
					} else {
						speed -= dec;
					}
				}
        		
        		distance += speed;
        	}
        	
        	wr.write("#" + tc + " " + distance + "\n");
        	wr.flush();
        }
	}

}
