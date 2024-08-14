import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	String read = br.readLine();
        	int count = 0;
        	
        	for (int i = 0; i < read.length() - 1; i++) {
        		char a = read.charAt(i);
        		char b = read.charAt(i + 1);
        		if (a == '(' && (b == ')' || b == '|')) {
					count++;
				} else if (a == '|' && b == ')') {
					count++;
				}
        	}
        	
        	sb.append(count).append("\n");
        }
        
        wr.write(sb.toString());
        wr.flush();
	}

}
