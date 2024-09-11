import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		String[] str1 = br.readLine().trim().split(" ");
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(str1[i]);
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		
		sb.append(min).append(" ").append(max);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
