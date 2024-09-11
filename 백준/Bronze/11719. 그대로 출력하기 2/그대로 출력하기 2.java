import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        // EOF에 도달할 때까지 입력을 받음
        while ((str = br.readLine()) != null) {
            System.out.println(str);  // 입력받은 내용을 그대로 출력
        }
    }
}
