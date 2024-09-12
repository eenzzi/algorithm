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
		
		for (int i = 0; i < N; i++) {
			
			// 별찍기 우선
			for (int j = 0; j < N - i; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
			
		}
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
