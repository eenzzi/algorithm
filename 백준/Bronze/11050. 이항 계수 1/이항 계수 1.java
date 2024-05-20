import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < k; i++) {
            numerator *= (n - i);
            denominator *= (i + 1);
        }


        System.out.println(numerator / denominator);


        br.close();
    }


}
