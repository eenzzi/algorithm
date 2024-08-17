
import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        int nx = (x + time) % (width * 2);
        int ny = (y + time) % (height * 2);

        if (nx > width) {
            nx = width - (nx - width);
        }
        if (ny > height) {
            ny = height - (ny - height);
        }

        sb.append(nx).append(" ").append(ny);
        System.out.println(sb);
    }

}