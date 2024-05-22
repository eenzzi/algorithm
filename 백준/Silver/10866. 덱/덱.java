
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            command(st, sb, deque);
        }

        System.out.println(sb);

        br.close();
    }

    private static void command(StringTokenizer st, StringBuilder sb, Deque<Integer> deque) {

        String command = st.nextToken();

        if (command.contains("push_front")) {
            int X = Integer.parseInt(st.nextToken());
            deque.addFirst(X);

        } else if (command.contains("push_back")) {
            int X = Integer.parseInt(st.nextToken());
            deque.addLast(X);

        } else if (command.contains("pop_front")) {
            try {
                sb.append(deque.removeFirst()).append("\n");
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }

        } else if (command.contains("pop_back")) {
            try {
                sb.append(deque.removeLast()).append("\n");
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }

        } else if (command.contains("size")) {
            sb.append(deque.size()).append("\n");

        } else if (command.contains("empty")) {
            if (deque.isEmpty()) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        } else if (command.equals("front")) {
            try {
                sb.append(deque.getFirst()).append("\n");
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }

        } else if (command.equals("back")) {
            try {
                sb.append(deque.getLast()).append("\n");
            } catch (NoSuchElementException e) {
                sb.append(-1).append("\n");
            }
        }
    }
}