import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int end, time;
        
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    
    List<List<Node>> graph;
    Set<Integer> summitSet, gateSet;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int w = path[2];
            
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }
        
        summitSet = new HashSet<>();
        gateSet = new HashSet<>();
        
        for (int s : summits) summitSet.add(s);
        for (int g : gates) gateSet.add(g);
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (intensity[now.end] < now.time) continue;
            if (summitSet.contains(now.end)) continue;
            
            for (Node next : graph.get(now.end)) {
                int newIntensity = Math.max(intensity[now.end], next.time);
                
                if (newIntensity < intensity[next.end]) {
                    intensity[next.end] = newIntensity;
                    pq.offer(new Node(next.end, newIntensity));
                }
            }
        }
                
        int num = 0;
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for (int s : summits) {
            if (intensity[s] < min) {
                num = s;
                min = intensity[s];
            }
        }
        
        return new int[]{num, min};
    }
}