import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N, M;
    static int[] graph, temp;
    static boolean[] visited;
    static StringTokenizer st;
//    static Set<Integer> set;
    static Map<Integer, Integer> map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            graph[i] = temp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp);
        map = new HashMap<>();
        int rank = 0;

        for(int element : temp) {
            if (!map.containsKey(element)) {
                map.put(element, rank);
                rank++;
            }
        }

        for (int i = 0; i < N; i++) {

            Integer count = map.get(graph[i]);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }



}