import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] isExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isExist = new boolean[N + 1];

        recur(0);
    }

    private static void recur(int start) {
        if (M == start) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isExist[i]) {
                isExist[i] = true;
                arr[start] = i;
                recur(start + 1);
                isExist[i] = false;
            }
        }
    }




}