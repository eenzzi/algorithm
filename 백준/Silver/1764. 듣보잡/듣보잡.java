import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, count;
    static HashSet<String> set;
    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = 0;
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            String read = br.readLine();
            if (set.contains(read)) {
                count++;
                result.add(read);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);


    }


}