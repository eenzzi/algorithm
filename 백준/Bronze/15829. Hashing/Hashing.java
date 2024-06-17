import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L;
    static String read;
    static char[] arr;
    static int r = 31;
    static int M = 1234567891;
    static int H;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(br.readLine());
        read = br.readLine();

        arr = read.toCharArray();

        for (int i = 0; i < L; i++) {
            int a = arr[i] - 'a' + 1;
            int n = 1;

            for (int j = 0; j < i; j++) {
                n *= r;
            }

            H += a * n;
        }

        H %= M;

        System.out.println(H);

    }


}