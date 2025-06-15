import java.util.*;

class Solution {
    
    static class Block implements Comparable<Block> {
        int num, x1, y1, x2, y2; // 검은 블록이 올 수 있는 좌표
        
        public Block(int num, int x1, int y1, int x2, int y2) {
            this.num = num;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        @Override
        public int compareTo(Block o) {
            int thisMaxY = Math.max(this.y1, this.y2);
            int otherMaxY = Math.max(o.y1, o.y2);
            return thisMaxY - otherMaxY;
        }
    }
    
    public int solution(int[][] board) {
        
        int N = board.length;
        int[] cnt = new int[201];
        int[] yStartArr = new int[201];
        
        Queue<Block> blocks = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) { // y
            
            int[] rowCnt = new int[201];
            
            for (int j = 0; j < N; j++) { // x
                int num = board[i][j];
                
                if (num == 0) continue;
                
                cnt[num]++;
                rowCnt[num]++;
                
                if (cnt[num] == 1) yStartArr[num] = i;
                
                // 없앨 수 있는 블록
                if (cnt[num] == 4 && rowCnt[num] >= 2) { 
                    int xStart = j - rowCnt[num] + 1;
                    int xEnd = j;
                    int yStart = yStartArr[num];
                    int yEnd = i;

                    // 검은 블록 좌표 등록
                    List<int[]> empties = new ArrayList<>();

                    for (int y = yStart; y <= yEnd; y++) {
                        for (int x = xStart; x <= xEnd; x++) {
                            if (board[y][x] != num) {
                                empties.add(new int[]{x, y});
                            }
                        }
                    }

                    if (empties.size() == 2) {
                        int[] e1 = empties.get(0);
                        int[] e2 = empties.get(1);
                        blocks.offer(new Block(num, e1[0], e1[1], e2[0], e2[1]));
                    }
                }
            }
        }
        
        int ans = 0;
        
        while (!blocks.isEmpty()) {
            Block block = blocks.poll();
            
            if (check(block, N, board)) { // 없앨 수 있는 블록이라면
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        if (board[y][x] == block.num) {
                            board[y][x] = 0; // 그 블록을 0으로 바꾸기
                        }
                    }
                }
                
                ans++;
            }
        }
        
        return ans;
    }
    
    // 없앨 수 있는 블록인지
    private boolean check(Block block, int N, int[][] board) {
        int[][] empties = { {block.x1, block.y1}, {block.x2, block.y2} };

        for (int[] pos : empties) {
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i <= y; i++) {
                if (board[i][x] != 0) return false; // 위에 블록이 있음
            }
        }

        return true;
    }
}