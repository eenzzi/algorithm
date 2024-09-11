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
		
		int num = 1;
		for (int i = 0; i < N; i++) {
			sb.append(num).append("\n");
			++num;
		}
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
