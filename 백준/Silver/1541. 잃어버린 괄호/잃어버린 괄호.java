import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int temp, result;
	static String formula;
	static StringTokenizer st1, st2;

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st1 = new StringTokenizer(br.readLine(), "-");
		result = Integer.MAX_VALUE;

		
		
		while (st1.hasMoreTokens()) {
			
			st2 = new StringTokenizer(st1.nextToken(), "+");
			
			temp = 0;
			
			while (st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			if (result == Integer.MAX_VALUE) {
				result = temp;
			} else {
				result -= temp;
			}
		}
		
		

			
		System.out.println(result);	
	}
	
	

	
	
}