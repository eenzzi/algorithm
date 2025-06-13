import java.util.*;

class Solution {
    
    static class Robot {
        int x, y, time;
        boolean isHorizon; // 방향이 수평인지
        
        Robot(int x, int y, int time, boolean isHorizon) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isHorizon = isHorizon;
        }
    }
    
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        N = board.length;
        
        Queue<Robot> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][2]; // 0: 세로, 1: 가로
        
        q.offer(new Robot(0, 0, 0, true));
        visited[0][0][1] = true;
        
        while(!q.isEmpty()) {
            Robot now = q.poll();
            
            int x = now.x;
            int y = now.y;
            int time = now.time;
            boolean isHorizon = now.isHorizon;

            // 도착 조건
            if ((isHorizon && x == N - 2 && y == N - 1) ||
                (!isHorizon && x == N - 1 && y == N - 2)) {
                return time;
            }
            
            // 이동
            for (int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (canMove(nx, ny, isHorizon, board) &&
                   !visited[ny][nx][isHorizon ? 1 : 0]) {
                    visited[ny][nx][isHorizon ? 1 : 0] = true;
                    q.offer(new Robot(nx, ny, time + 1, isHorizon));
                }
            }

            // 가로 -> 세로 회전
            if (isHorizon) {
                for (int dir : new int[]{-1, 1}) {
                    int ny = y + dir;
                    if (ny >= 0 && ny < N &&
                        board[y][x] == 0 && board[y][x + 1] == 0 &&
                        board[ny][x] == 0 && board[ny][x + 1] == 0) {

                        int baseY = Math.min(y, ny);
                        // 왼쪽 축 기준 회전
                        if (!visited[baseY][x][0]) {
                            visited[baseY][x][0] = true;
                            q.offer(new Robot(x, baseY, time + 1, false));
                        }
                        // 오른쪽 축 기준 회전
                        if (!visited[baseY][x + 1][0]) {
                            visited[baseY][x + 1][0] = true;
                            q.offer(new Robot(x + 1, baseY, time + 1, false));
                        }
                    }
                }
            } else {
                // 세로 -> 가로 회전
                for (int dir : new int[]{-1, 1}) {
                    int nx = x + dir;
                    if (nx >= 0 && nx < N &&
                        board[y][x] == 0 && board[y + 1][x] == 0 &&
                        board[y][nx] == 0 && board[y + 1][nx] == 0) {

                        int baseX = Math.min(x, nx);
                        // 위쪽 축 기준 회전
                        if (!visited[y][baseX][1]) {
                            visited[y][baseX][1] = true;
                            q.offer(new Robot(baseX, y, time + 1, true));
                        }
                        // 아래쪽 축 기준 회전
                        if (!visited[y + 1][baseX][1]) {
                            visited[y + 1][baseX][1] = true;
                            q.offer(new Robot(baseX, y + 1, time + 1, true));
                        }
                    }
                }
            }

        }
        
        return 0;
    }

    private boolean canMove(int x, int y, boolean isHorizon, int[][] board) {
        if (x < 0 || y < 0 || x >= N || y >= N) return false;
        if (isHorizon) { // 가로
            return x + 1 < N &&
                   board[y][x] == 0 &&
                   board[y][x + 1] == 0;
        } else {
            return y + 1 < N &&
                   board[y][x] == 0 &&
                   board[y + 1][x] == 0;
        }
    }
}