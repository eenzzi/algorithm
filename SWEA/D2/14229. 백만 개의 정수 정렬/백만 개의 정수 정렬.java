
import java.io.*;
import java.util.*;

public class Solution {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 1000000;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken().trim());
        }

        quickSort(0, N - 1);
        System.out.println(arr[500000]);
    }

    private static void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    private static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = tmp;
        return i + 1;
    }
}
