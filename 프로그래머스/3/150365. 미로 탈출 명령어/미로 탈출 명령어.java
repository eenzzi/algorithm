import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 0, -1}; // dlru
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        
        int dist = Math.abs(x - r) + Math.abs(y - c); // 남은 거리
        if (dist > k || (k - dist) % 2 != 0) return "impossible";
        
        int remain = k;
        while (remain > 0) {
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                
                dist = Math.abs(nx - r) + Math.abs(ny - c);
                
                if (dist > remain - 1) continue;
                if ((remain - 1 - dist) % 2 != 0) continue;
                
                sb.append(dir[i]);
                x = nx;
                y = ny;
                remain--;
                break;
            }
        }
        
        return sb.toString();
    }
}