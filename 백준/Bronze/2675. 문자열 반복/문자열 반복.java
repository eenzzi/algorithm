import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, R;
    static String S;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            print(R, S);
        }

    }

    private static void print(int R, String S) {

        StringBuilder sb = new StringBuilder();
        String[] split = S.split("");

        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < R; j++) {
                sb.append(split[i]);
            }
        }

        System.out.println(sb);
    }


}
