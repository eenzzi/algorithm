
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, result, max, num;
	static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            len = new int[N];
            result = 0;
            max = 0;
            num = 0;
            
            for (int i = 0; i < N; i++) {
            	len[i] = Integer.parseInt(st.nextToken());
            	max = Math.max(max, len[i]);
            }
            
            int odd = 0;
            int even = 0;
            for (int i = 0; i < N; i++) {
            	len[i] = max - len[i];
            	num += len[i];
            	
            	if (len[i] % 2 == 0 && !(len[i] == 0)) {
					even++;
				} else if (len[i] % 2 == 1){
					odd++;
				}	
            }
            
            if (odd > 0) {
            	num -= (odd * 3 - 2);
                result += (odd * 2 - 1);
			}

            if (num < 0) {
				num = 0;
			}
        	result += (num / 6 * 4);
        	if (num % 6 == 2) {
        		if (odd == 0) {
					result += 2;
				} else {
					result += 1;	
				}
			} else if (num % 6 == 4) {
				result += 3;
			}
			
            
            sb.append(result).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
	}

}
