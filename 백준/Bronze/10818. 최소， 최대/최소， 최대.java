import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, min, max;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        min = 1000000;
        max = -1000000;

        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();

        System.out.println(sb.append(min).append(" ").append(max));


    }



}