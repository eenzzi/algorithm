import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int current = 0;
        int statick = k;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < k; j++) {

                if (arr[current % n] == -1) {
                    k++;
                    current++;
                } else {
                    current++;
                }
            }

            k = statick;

            sb.append(arr[(current - 1) % n]).append(", ");
            arr[(current - 1) % n] = -1;
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);

        br.close();
    }
}