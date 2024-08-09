import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] read = br.readLine().split("");
			int N = read.length;
			int result = 0;
			String current = "0";
			
			for (int i = 0; i < N; i++) {
				if (!read[i].equals(current)) {
					result++;
				}
				current = read[i];
			}
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
		}
	}

}
