import java.util.*;

public class Main {

    static int n = 9;
    static int[] arr = new int[n];
    static int temp = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {

                if (arr[i] > temp) {
                    temp = arr[i];
                }

        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == temp) {
                System.out.println(arr[i]);
                System.out.println(i + 1);
            }
        }

        sc.close();

    }


}
