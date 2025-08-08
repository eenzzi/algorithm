import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int end, cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    List<List<Node>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            
            graph.get(c).add(new Node(d, f));
            graph.get(d).add(new Node(c, f));
        }
        
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) { // i: 중간 지점
            int cost = 0;
            cost += dijkstra(n, s, i);
            cost += dijkstra(n, i, a);
            cost += dijkstra(n, i, b);
            
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
    
    public int dijkstra(int n, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.end] < now.cost) continue;
            if (now.end == end) return dist[end];
            
            for (Node next : graph.get(now.end)) {
                int nextCost = next.cost + now.cost;
                
                if (nextCost < dist[next.end]) {
                    dist[next.end] = nextCost;
                    pq.offer(new Node(next.end, nextCost));
                }
            }
        }
        
        return dist[end];
    }
}