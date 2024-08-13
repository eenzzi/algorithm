
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	static int N;
	static boolean[] check;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	check = new boolean[10];
        	int count = 0;
        	int checkCount = 0;
        	
        	String num = "";
        	
        	while(checkCount != 10) {
        		
        		int k = N * (count + 1);
        		num = "" + k;
        		
        		for (int i = 0; i < num.length(); i++) {
        			int idx = num.charAt(i) - '0';
            		if (!check[idx]) {
    					check[idx] = true;
    					checkCount++;
    				}
            	}
        		count++;
        	}
        	
        	wr.write("#" + tc + " " + num + "\n");
        	wr.flush();
        }
	}

}
