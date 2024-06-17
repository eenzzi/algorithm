import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int arr[] = new int[6];
    static int T, P;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int ans1 = 0;

        for (int i = 0; i < 6; i++) {
            if (arr[i] != 0) {
                ans1 += ((arr[i] - 1) / T + 1);
            }
        }

        int ans2, ans3;
        ans2 = n / P;
        ans3 = n % P;


        System.out.println(ans1);
        System.out.println(ans2 + " " + ans3);

    }


}
