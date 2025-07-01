class Solution {
    
    int[] info;
    int[][] edges;
    int max, N;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        max = 0;
        N = info.length;
        boolean[] visited = new boolean[N];
        
        dfs(0, 0, 0, visited);
        
        return max;
    }
    
    public void dfs(int num, int sheep, int wolf, boolean[] visited) {
        visited[num] = true;
        
        if (info[num] == 0) {
            sheep++;
            max = Math.max(sheep, max);
        } else {
            wolf++;
        }
        
        if (sheep <= wolf) return;
        
        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] next = new boolean[N];
                for (int i = 0; i < N; i++) {
                    next[i] = visited[i];
                }
                
                dfs(edge[1], sheep, wolf, next);
            }
        }
    }
}