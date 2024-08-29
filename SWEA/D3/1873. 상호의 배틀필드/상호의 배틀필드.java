
import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int HEIGHT, WIDTH, N, curX, curY;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            HEIGHT = Integer.parseInt(st.nextToken());
            WIDTH = Integer.parseInt(st.nextToken());
            arr = new char[HEIGHT][WIDTH];

            for (int i = 0; i < HEIGHT; i++) {
                String read = br.readLine();
                for (int j = 0; j < WIDTH; j++) {
                    arr[i][j] = read.charAt(j);

                    if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
                        curX = i;
                        curY = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String read = br.readLine();
            for (int i = 0; i < N; i++) {
                char input = read.charAt(i);
                command(input);
            }

            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }

        wr.write(sb.toString());
        wr.flush();
    }

    private static void command(char input) {
        if (input == 'U') {
            arr[curX][curY] = '^';
            if (curX == 0) {
                return;
            }
            if (arr[curX - 1][curY] == '.') {
                arr[curX][curY] = '.';
                curX--;
                arr[curX][curY] = '^';
            }
        } else if (input == 'D') {
            arr[curX][curY] = 'v';
            if (curX == HEIGHT - 1) {
                return;
            }
            if (arr[curX + 1][curY] == '.') {
                arr[curX][curY] = '.';
                curX++;
                arr[curX][curY] = 'v';
            }
        } else if (input == 'L') {
            arr[curX][curY] = '<';
            if (curY == 0) {
                return;
            }
            if (arr[curX][curY - 1] == '.') {
                arr[curX][curY] = '.';
                curY--;
                arr[curX][curY] = '<';
            }
        } else if (input == 'R') {
            arr[curX][curY] = '>';
            if (curY == WIDTH - 1) {
                return;
            }
            if (arr[curX][curY + 1] == '.') {
                arr[curX][curY] = '.';
                curY++;
                arr[curX][curY] = '>';
            }
        } else { //shoot
            char dir = arr[curX][curY];
            if (dir == '^') {
                for (int i = 1; i <= curX; i++) {
                    if (arr[curX - i][curY] == '#') {
                        return;
                    } else if (arr[curX - i][curY] == '*') {
                        arr[curX - i][curY] = '.';
                        return;
                    }
                }
            } else if (dir == 'v') {
                for (int i = 1; i <= HEIGHT - 1 - curX; i++) {
                    if (arr[curX + i][curY] == '#') {
                        return;
                    } else if (arr[curX + i][curY] == '*') {
                        arr[curX + i][curY] = '.';
                        return;
                    }
                }
            } else if (dir == '<') {
                for (int i = 1; i <= curY; i++) {
                    if (arr[curX][curY - i] == '#') {
                        return;
                    } else if (arr[curX][curY - i] == '*') {
                        arr[curX][curY - i] = '.';
                        return;
                    }
                }
            } else {
                for (int i = 1; i <= WIDTH - 1 - curY; i++) {
                    if (arr[curX][curY + i] == '#') {
                        return;
                    } else if (arr[curX][curY + i] == '*') {
                        arr[curX][curY + i] = '.';
                        return;
                    }
                }
            }
        }
    }
}
