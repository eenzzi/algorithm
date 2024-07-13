import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, white, blue;
    static Integer[] dp;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutting(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cutting(int row, int col, int size) {

        if (check(row, col, size)) {
            if (arr[row][col] == 1) {
                blue++;
            } else {
                white++;
            }

            return;
        }

        int newSize = size / 2;

        cutting(row, col, newSize);
        cutting(row + newSize, col, newSize);
        cutting(row , col + newSize, newSize);
        cutting(row + newSize, col + newSize, newSize);

    }

    private static boolean check(int row, int col, int size) {

        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }




}
