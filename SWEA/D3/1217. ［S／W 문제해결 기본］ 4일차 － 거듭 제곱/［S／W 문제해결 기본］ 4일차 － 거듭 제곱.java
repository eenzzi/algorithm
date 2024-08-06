
import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {
		
		//Scanner 제약
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + tc + " " + recur(N, M));
		}

	}
	
	private static int recur(int N, int M) {
		if (M == 1) {
			return N;
		}
		
		return N * recur(N, M - 1);
	}

}
