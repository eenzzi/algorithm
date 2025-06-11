import java.util.*;

class Solution {
    
    static int N, M, T;
    static int[][] totalMap;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        M = key.length;
        N = lock.length;
        T = N + (M - 1) * 2; // Total 크기
        
        totalMap = new int[T][T];
        for (int i = 0; i < T; i++) {
            Arrays.fill(totalMap[i], 1); // 1로 채우기
        }
        
        int hole = 0; // 홈의 갯수
        
        // map 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int isHole = lock[i][j];
                totalMap[i + (M - 1)][j + (M - 1)] = isHole;
                if (isHole == 0) hole++;
            }
        }
        
        // 찾기
        for (int i = 0; i < T - (M - 1); i++) {
            for (int j = 0; j < T - (M - 1); j++) {
                for (int k = 0; k < 4; k ++) {
                    key = rotate(key);
                    boolean isMatched = isMatched(key, i, j, hole);
                    
                    if (isMatched) return true;
                }
            }
        }
        
        
        return false;
    }
    
    private int[][] rotate(int[][] key) {
        int[][] result = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = key[j][M - 1 - i];
            }
        }
        return result;
    }
    
    private boolean isMatched(int[][] key, int x, int y, int hole) {
            int filled = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    int r = i + x;
                    int c = j + y;
                    
                    if(x == 2 && y == 2) {
                        System.out.println("KEY" + key[i][j]);
                        System.out.println("MAP" + totalMap[r][c]);
                        
                    }

                    if (r >= M - 1 && r < M - 1 + N && c >= M - 1 && c < M - 1 + N) {
                        if(key[i][j] == 1 && totalMap[r][c] == 1) return false; 
                        if (key[i][j] == 1 && totalMap[r][c] == 0) filled++;
                    }
                }
            }
            System.out.println("FILLED" + filled);

            return filled == hole;
    }
}