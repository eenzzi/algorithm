import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        Map<Integer, Integer> map = new HashMap<>(); // <a,b> -> b를 가야 a를 갈 수 있음
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            graph.get(path[i][0]).add(path[i][1]);
            graph.get(path[i][1]).add(path[i][0]);
        }
        
        for (int[] o : order) {
            map.put(o[1], o[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        if (map.containsKey(0)) {
            return false;
        }
        
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Integer> wait = new HashMap<>();
        
        while(!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;
                        
            if (wait.containsKey(now)) {
                q.offer(wait.get(now));
            }
            
            List<Integer> list = graph.get(now); // 다음 연결된 리스트
            
            for (int next : list) {
                if (visited[next]) continue;
                
                if (map.containsKey(next)) { // 선행조건이 있는 노드라면
                    int required = map.get(next);
                    if(!visited[required]) {
                        wait.put(required, next);
                        continue;
                    }
                }
                
                q.offer(next);     
                
            }
        }
        
        boolean answer = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) answer = false;
        }
        return answer;
    }
}