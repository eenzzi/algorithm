
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, K; //셀의 수, 격리 시간, 군집의 개수
    static ArrayList<Community>[][] arr;
    static ArrayList<Community> list; //현재 군집 리스트
    static int[] dx = {0, -1, 1, 0, 0}; //상 하 좌 우
    static int[] dy = {0, 0, 0, -1, 1};

    static class Community {
        int x;
        int y;
        int count;
        int dir;

        public Community(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            arr = new ArrayList[N][N];

            for (int i= 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                Community c = new Community(x, y, count, dir);

                list.add(c);
            }

            for (int i = 0; i < M; i++) {
                move();
                combine();
            }

            int result = 0;
            for(Community c : list) {
                result += c.count;
            }

            sb.append(result).append("\n");
        }

        wr.write(sb.toString());
        wr.flush();

    }

    private static void move() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for(Community c : list) {

            c.x += dx[c.dir];
            c.y += dy[c.dir]; //move

            arr[c.x][c.y].add(c); //배열에 저장

            //가장자리에 도달했을 때
            if (c.x == 0 || c.y == 0 || c.x == N - 1 || c.y == N -1) {
                c.count /= 2;

                if (c.dir % 2 == 1) { //상 or 좌
                    c.dir++;
                } else { //하 or 우
                    c.dir--;
                }

//                if (c.count == 0) {
//                    list.remove(c);
//                }
            }
        }
    }

    private static void combine() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = arr[i][j].size();

                if (cnt ==1) {
                    Community c = arr[i][j].get(0);
                    if (c.count == 0) {
                        list.remove(c);
                    }

                } else if (cnt > 1) {
                    int sum = 0; // 합
                    int max = 0; // 미생물 수가 제일 큰 곳의 미생물 수
                    int dir = 0; // 미생물 수가 제일 큰 곳의 이동방향

                    for (Community c : arr[i][j]) {
                        sum += c.count;
                        if (c.count > max) {
                            max = c.count;
                            dir = c.dir;
                        }

                        list.remove(c);
                    }

                    Community c = new Community(i, j, sum, dir);
                    list.add(c);
                }



            }
        }
    }
}

