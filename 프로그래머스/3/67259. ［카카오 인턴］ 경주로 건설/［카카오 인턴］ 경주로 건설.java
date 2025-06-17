import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    class Node {
        int x, y, dir, cost;
        
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
     
    public int solution(int[][] board) {
        
        int N = board.length;
        List<Integer> answers = new ArrayList<>();
        int[][][] costMap = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(costMap[i][j], Integer.MAX_VALUE);
            }
        }
                
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, -1, 0));
        
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == N - 1 && node.y == N - 1) {
                answers.add(node.cost);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >= N || ny >= N || nx < 0 || ny < 0 || board[nx][ny] == 1) continue;
                int cost = node.cost;
                if (node.dir != i && node.dir != -1) cost += 500; // 코너
                if (costMap[nx][ny][i] < cost + 100) continue;

                costMap[nx][ny][i] = cost + 100;
                q.offer(new Node(nx, ny, i, cost + 100));
            }
        }
        
        return Collections.min(answers);
    }
}