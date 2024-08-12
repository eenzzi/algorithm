import java.io.*;
import java.util.*;

public class Solution {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int num = i;
            int count = 0;
            while (num != 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    count++;
                }
                num /= 10;
            }

            if (count == 0) {
                sb.append(i);
            } else {
                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }
            }
            sb.append(" ");
        }


        wr.write(String.valueOf(sb));
        wr.flush();
    }
}