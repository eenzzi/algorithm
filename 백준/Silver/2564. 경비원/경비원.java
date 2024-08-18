
import java.io.*;
import java.util.*;

public class Main {

    static int W, H, N;
    static int[][] arr;
    static int[] dir, pos, store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        dir = new int[N];
        pos = new int[N];
        store = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            pos[i] = Integer.parseInt(st.nextToken());

            store[i] = position(dir[i], pos[i]);
        }

        st = new StringTokenizer(br.readLine());

        int curDir = Integer.parseInt(st.nextToken());
        int curPos = Integer.parseInt(st.nextToken());

        curPos = position(curDir, curPos);
        int len = (W + H) * 2;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int clock = Math.abs(curPos - store[i]);
            int countClock = len - clock;
            result += Math.min(clock, countClock);
        }

        System.out.println(result);
    }

    private static int position(int d, int p) {
        if (d == 1) {
            return p;
        } else if (d == 2) {
            return W + H + (W - p);
        } else if (d == 3) {
            return W * 2 + H + (H - p);
        } else {
            return W + p;
        }
    }

}
