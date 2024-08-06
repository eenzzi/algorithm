import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			
			Stack<Character> stack = new Stack<>();
			
			int len = Integer.parseInt(br.readLine());
			String expression = br.readLine();
			String postfix = "";
			
			//후위 표기식으로 바꾸기
			for (int i = 0; i < len; i++) {
				char c = expression.charAt(i);
				
				if ('0' <= c && '9' >= c) { //피연산자 일 때
					postfix += c;
				} else {
					if (stack.isEmpty()) {
						stack.add(c);
					} else {
						postfix += stack.pop();
						stack.add(c);
					}
				}
			}
			
			//계산
			int result = 0;
			Stack<Integer> stack2 = new Stack<>();
			
			for (int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				
				if ('0' <= c && '9' >= c) { //피연산자 일 때
					stack2.push(c - '0');
				} else {
					int num1 = stack2.pop();
					int num2 = stack2.pop();
					result = num2 + num1;
					
					stack2.push(result);
				}
				
			}
			
			result += stack2.pop();
			
			wr.write("#" + tc + " " + result + "\n");
			wr.flush();
			
		}

	}

}