
import java.io.*;
public class Solution {
	
	static int N;
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	int[] result = new int[8];
        	

    		for (int i = 0; i < money.length; i++) {
    			result[i] += N / money[i];
				N %= money[i];
    		}
        	
        	wr.write("#" + tc + "\n");
        	for (int i = 0; i < result.length; i++) {
        		wr.write(result[i] + " ");
        	}
        	wr.write("\n");
        	wr.flush();
        }
	}

}
