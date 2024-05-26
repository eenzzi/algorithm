import java.util.*;

public class Main {

    static int V, E;
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int infectedCount = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        graph = new ArrayList<>();
        isVisited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(i, new LinkedList<>());
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        infect(1);

        System.out.println(infectedCount);

        sc.close();
    }

    private static void infect(int start) {

        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {

            int v = queue.poll();

            for (Integer i : graph.get(v)) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    infectedCount++;
                    queue.add(i);
                }
            }
        }



    }


}
