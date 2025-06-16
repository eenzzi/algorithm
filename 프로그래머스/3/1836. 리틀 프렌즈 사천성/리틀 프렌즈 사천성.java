import java.util.*;

class Solution {

    public String solution(int m, int n, String[] board) {
        Map<Character, int[][]> mapPoint = new HashMap<>();
        char[][] map = new char[m][n];

        // 보드 초기화 및 알파벳 좌표 수집
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                map[i][j] = c;

                if (c == '*' || c == '.') continue;

                int[][] positions = mapPoint.computeIfAbsent(c, k -> new int[2][2]);

                if (positions[0][0] == 0 && positions[0][1] == 0 && !(i == 0 && j == 0 && c == board[0].charAt(0))) {
                    positions[0][0] = i;
                    positions[0][1] = j;
                } else {
                    positions[1][0] = i;
                    positions[1][1] = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            List<Character> removable = new ArrayList<>();

            for (char c : mapPoint.keySet()) {
                int[][] pos = mapPoint.get(c);
                if (connect(pos[0], pos[1], map)) {
                    removable.add(c);
                }
            }

            if (removable.isEmpty()) {
                return mapPoint.isEmpty() ? sb.toString() : "IMPOSSIBLE";
            }

            Collections.sort(removable);
            char c = removable.get(0);
            int[][] pos = mapPoint.get(c);

            // 맵에서 제거
            map[pos[0][0]][pos[0][1]] = '.';
            map[pos[1][0]][pos[1][1]] = '.';

            sb.append(c);
            mapPoint.remove(c);
        }
    }

    public boolean connect(int[] a, int[] b, char[][] map) {
        int ax = a[0], ay = a[1];
        int bx = b[0], by = b[1];

        // 직선 연결
        if (ax == bx && clearHorizontal(ax, ay, by, map)) return true;
        if (ay == by && clearVertical(ay, ax, bx, map)) return true;

        // ㄱ자 연결 1
        if (map[ax][by] == '.' && clearHorizontal(ax, ay, by, map) && clearVertical(by, ax, bx, map)) return true;

        // ㄱ자 연결 2
        if (map[bx][ay] == '.' && clearVertical(ay, ax, bx, map) && clearHorizontal(bx, ay, by, map)) return true;

        return false;
    }

    public boolean clearHorizontal(int x, int y1, int y2, char[][] map) {
        if (y1 > y2) {
            int tmp = y1; y1 = y2; y2 = tmp;
        }

        for (int y = y1 + 1; y < y2; y++) {
            if (map[x][y] != '.') return false;
        }
        return true;
    }

    public boolean clearVertical(int y, int x1, int x2, char[][] map) {
        if (x1 > x2) {
            int tmp = x1; x1 = x2; x2 = tmp;
        }

        for (int x = x1 + 1; x < x2; x++) {
            if (map[x][y] != '.') return false;
        }
        return true;
    }
}