import java.util.*;
 
public class Main {
 
    static int n, m;
    static boolean[] sight;
    static ArrayList<Node>[] list;
    static long[] dist;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        //입력
        n = scan.nextInt();
        m = scan.nextInt();
 
        sight = new boolean[n];
        for(int i = 0; i < n; i++) {
            int flag = scan.nextInt();
            if(flag == 1) sight[i] = true;
            else sight[i] = false;
        }
 
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
 
        for(int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int c = scan.nextInt();
            list[s].add(new Node(e, c));
            list[e].add(new Node(s, c));
        }
 
        dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        dijkstra();
 
        if(dist[n - 1] == Long.MAX_VALUE) System.out.println("-1");
        else System.out.println(dist[n - 1]);
    }
 
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        q.offer(new Node(0, 0));
 
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            if(visited[current.node]) continue;
            visited[current.node] = true;
 
            for(int i = 0; i < list[current.node].size(); i++) {
                Node next = list[current.node].get(i);
                if(next.node != n - 1 && sight[next.node]) continue;
                if(dist[next.node] > dist[current.node] + next.cost) {
                    dist[next.node] = dist[current.node] + next.cost;
                    q.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
 
    public static class Node implements Comparable<Node> {
        int node;
        long cost;
 
        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Node n) {
            if(this.cost - n.cost > 0) return 1;
            else return -1;
        }
    }
}
