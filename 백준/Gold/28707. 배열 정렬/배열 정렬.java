
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static List<Op> ops;

    static class State implements Comparable<State> {
        int[] arr;
        int cost;

        public State(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }

    static class Op {
        int l, r, cost;

        public Op(int l, int r, int cost) {
            this.l = l;
            this.r = r;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        ops = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            ops.add(new Op(l, r, c));
        }

        // 다익스트라
        PriorityQueue<State> pq = new PriorityQueue();
        pq.offer(new State(arr, 0));

        Map<String, Integer> visited = new HashMap<>();
        visited.put(Arrays.toString(arr), 0);

        int[] target = arr.clone();
        Arrays.sort(target);

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (Arrays.equals(target, cur.arr)) {
                System.out.println(cur.cost);
                return;
            }

            for (Op op : ops) {
                int[] next = cur.arr.clone();

                // l <-> r
                int temp = next[op.l];
                next[op.l] = next[op.r];
                next[op.r] = temp;

                int nextCost = cur.cost + op.cost;
                String nextKey = Arrays.toString(next);

                if (!visited.containsKey(nextKey) || visited.get(nextKey) > nextCost) {
                    pq.offer(new State(next, nextCost));
                    visited.put(nextKey, nextCost);
                }
            }
        }

        System.out.println(-1);
    }

}
