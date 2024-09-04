
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean result = false;
            ArrayList<String> phoneNum = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                phoneNum.add(br.readLine());
            }
            Collections.sort(phoneNum);

            for (int j = 0; j < N - 1; j++) {
                String a = phoneNum.get(j); //앞
                String b = phoneNum.get(j + 1); //뒤
                if (a.length() > b.length()) {
                    continue;
                }
                if (a.equals(b.substring(0, a.length()))) {
                    result = true;
                    break;
                }
            }
            if (result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
