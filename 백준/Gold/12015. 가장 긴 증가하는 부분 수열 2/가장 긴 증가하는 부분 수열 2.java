
import java.io.*;
import java.util.*;

public class Main {
    static int n, len;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        len = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            insert(num);
        }

        System.out.println(len);
    }

    public static void insert(int num) {
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        arr[left] = num;

        if (left == len) len++; // 맨 뒤에 붙으면 길이 증가
    }

}