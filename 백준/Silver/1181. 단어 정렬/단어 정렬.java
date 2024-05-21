import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    arr[i] = "";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!arr[i].equals("")) {
                System.out.println(arr[i]);
            }
        }


        br.close();
    }
}
