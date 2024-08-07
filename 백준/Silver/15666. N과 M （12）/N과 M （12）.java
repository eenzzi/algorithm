
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        nums = new int[M];
        printArr(0, 0);
    }

    private static void printArr(int now, int start) {
        if (now == M) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        int dupl = 0;
        for (int i = start; i < N; i++) {
            if (dupl == arr[i]) {
                continue;
            }
            nums[now] = arr[i];
            printArr(now + 1, i);
            dupl = arr[i];
        }
    }



}