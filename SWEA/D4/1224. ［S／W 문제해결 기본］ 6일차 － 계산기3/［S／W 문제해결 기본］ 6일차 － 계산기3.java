import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		
		for (int tc = 1; tc <= T; tc++) {
			
			Stack<Character> stack = new Stack<>();
			
			int len = Integer.parseInt(br.readLine());
			String expression = br.readLine();
			
			String postfix = toPostFix(expression, len);
			wr.write("#" + tc + " " + evalPostFix(postfix) + "\n");
			wr.flush();
		}
	}
	
	//후위 표기법
	private static String toPostFix(String infix, int len) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < len; i++) {
			char c = infix.charAt(i);
			
			if (c >= '0' && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() &&
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	private static int evalPostFix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result;
				
				if (c == '+') {
					result = num2 + num1;
				} else if (c == '-') {
					result = num2 - num1;
				} else if (c == '*') {
					result = num2 * num1;
				} else {
					result = num2 / num1;
				}
				
				stack.push(result);
			}
		}
		
		return stack.pop();

	}

}