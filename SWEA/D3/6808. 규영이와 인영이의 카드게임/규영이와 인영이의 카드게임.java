
import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int[] card1, card2, inyoung;
    static boolean[] visited, visited2;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            card1 = new int[9];
            card2 = new int[9];
            visited = new boolean[19];

            for (int i = 0; i < 9; i++) {
                card1[i] = Integer.parseInt(st.nextToken());
                visited[card1[i]] = true;
            }

            int count = 0;
            for (int i = 1; i < 19; i++) {
                if (!visited[i]) {
                    card2[count] = i;
                    count++;
                }
            }

            inyoung = new int[9];
            visited2 = new boolean[9];
            win = 0;
            lose = 0;

            recur(0);

            sb.append(win).append(" ").append(lose).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
    }

    private static void game() {
        int gyu = 0;
        int young = 0; // 규영이 인영이

        for (int i = 0; i < 9; i++) {
            if (card1[i] > inyoung[i]) { // 규영이가 이긴경우
                gyu += (card1[i] + inyoung[i]);
            } else if (card1[i] < inyoung[i]) { // 인영이가 이긴 경우
                young += (card1[i] + inyoung[i]);
            }
        }

        if (gyu > young) {
            win++;
        } else if (gyu < young) {
            lose++;
        }
    }

    private static void recur(int idx) {
        if (idx == 9) {
            game();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited2[i]) {
                continue;
            }
            inyoung[idx] = card2[i];
            visited2[i] = true;
            recur(idx + 1);
            visited2[i] = false;
        }
    }
}
