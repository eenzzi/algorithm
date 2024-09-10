import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if (str == null || str.isEmpty()) {
				break;
				

			} else {
				String[] str1 = str.trim().split(" ");
				int A = Integer.parseInt(str1[0]);
				int B = Integer.parseInt(str1[1]);
				sb.append(A + B).append("\n");
			}

		}

		System.out.println(sb);

	} // 메인 끝

}
