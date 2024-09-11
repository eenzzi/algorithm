import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		String[] str1 = br.readLine().trim().split("");
		int[] nums = new int[str1.length];
		int sum = 0;
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(str1[n]);
			sum += nums[n];
		}
		
		sb.append(sum);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
