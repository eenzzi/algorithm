import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String read = st.nextToken();

            if (read.contains("add")) {
                int x = Integer.parseInt(st.nextToken());
                add(x);
            } else if (read.contains("remove")) {
                int x = Integer.parseInt(st.nextToken());
                remove(x);
            } else if (read.contains("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(check(x)).append("\n");
            } else if (read.contains("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                toggle(x);
            } else if (read.contains("all")) {
                all();
            } else if (read.contains("empty")) {
                empty();
            }
        }

        System.out.println(sb);
    }

    private static void add(int x) {
        set.add(x);
    }

    private static void remove(int x) {
        set.remove(x);
    }

    private static int check(int x) {
        boolean contains = set.contains(x);
        if (contains) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    private static void all() {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    private static void empty() {
        set.clear();
    }
}