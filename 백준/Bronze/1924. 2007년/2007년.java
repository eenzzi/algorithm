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
		
		String[] date = br.readLine().trim().split(" ");
		int x = Integer.parseInt(date[0]);
		int y = Integer.parseInt(date[1]);
		
		// 날짜 처리
		
		
		int day = 0; // 요일을 처리할 변수 day
		
		if (x == 1) {
			day += y;
		} else {
			for (int i = 0; i < x; i++) {
				if (i == 1 ||i == 3 || i == 5 || i ==7
						|| i == 8 || i == 10 || i == 12) {
					day += 31;
				} else if (i == 4 || i == 6 || i == 9 || i ==11) {
					day += 30;
				} else if (i == 2) {
					day += 28;
				} 
			}
			day += y;
		}
		
		if (day % 7 == 0) sb.append("SUN");
		if (day % 7 == 1) sb.append("MON");
		if (day % 7 == 2) sb.append("TUE");
		if (day % 7 == 3) sb.append("WED");
		if (day % 7 == 4) sb.append("THU");
		if (day % 7 == 5) sb.append("FRI");
		if (day % 7 == 6) sb.append("SAT");
		
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // 메인 끝

}
