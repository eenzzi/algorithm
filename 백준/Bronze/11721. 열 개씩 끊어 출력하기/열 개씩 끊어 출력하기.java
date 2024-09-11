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
		
		String[] str1 = br.readLine().trim().split("");
		for (int i = 0; i < str1.length; i++) {
			
			if (i != 0 && (i + 1) % 10 == 0) {
				sb.append(str1[i]).append("\n");
			} else {
				sb.append(str1[i]);
			}
		}
		
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
