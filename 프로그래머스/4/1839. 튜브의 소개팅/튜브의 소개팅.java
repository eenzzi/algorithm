import java.util.*;

class Solution {
    
    class Node {
        int x, y, dist;
        long time;
        
        public Node (int x, int y, int dist, long time) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.time = time;
        }
    }
    
    public int[] solution(int m, int n, int s, int[][] time_map) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        long[][] minTime = new long[m][n];
        for (long[] row : minTime) Arrays.fill(row, Long.MAX_VALUE);
        
        // 거리 우선 같으면 시간
        // PriorityQueue<Node> pq = new PriorityQueue<>(
        //     (a, b) -> a.dist != b.dist ? a.dist - b.dist : a.time - b.time
        // );
        
        Queue<Node> pq = new LinkedList<>();
        
        pq.offer(new Node(0, 0, 0, time_map[0][0]));
        minTime[0][0] = time_map[0][0];
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.time > s) continue;
            
            if (now.x == m - 1 && now.y == n -1) {
                if (now.dist < answer[0] ||
                   (now.dist == answer[0] && now.time < answer[1])) {
                    answer[0] = now.dist;
                    answer[1] = (int)now.time;
                }
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (time_map[nx][ny] == -1) continue;
                
                int nextDist = now.dist + 1;
                long nextTime = now.time + time_map[nx][ny];
                
                if (nextTime > s) continue;
                
                if (nextTime < minTime[nx][ny]) {
                    minTime[nx][ny] = nextTime;
                    pq.offer(new Node(nx, ny, nextDist, nextTime));
                }
            }
        }

        return answer;
    }
}