import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(print(n));
        }



        br.close();
    }

    private static int print(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return (print(n - 3) + print(n - 2) + print(n - 1));
        }
    }
}