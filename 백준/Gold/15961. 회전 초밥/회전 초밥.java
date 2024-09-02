
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;
    static int[] arr, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        count = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k - 1;
        int max = 1;
        count[c]++;

        for (int i = start; i <= end; i++) {
            if (count[arr[i]] == 0) {
                max++;
            }
            count[arr[i]]++;
        }

        int cnt = max;
        for (int i = 0; i < N; i++) {
            int a = arr[i];
            int b = arr[(i + k) % N];

            if (count[a] == 1) { //a가 하나면 빠지면 줄어듦
                cnt--;
            }
            count[a]--;

            if (count[b] == 0) { // b가 없으면 하나 추가됨
                cnt++;
            }
            count[b]++;

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }

}
