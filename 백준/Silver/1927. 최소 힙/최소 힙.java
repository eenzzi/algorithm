import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int N, max;
	static PriorityQueue<Integer> heap;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		heap = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			heap(input);
		}
		
		System.out.println(sb);
	}
	
	private static void heap(int input) {
		
		if(input == 0) {
			if(heap.isEmpty()) {
				sb.append(0 + "\n");
			} else {
				int min = heap.poll();
				sb.append(min + "\n");
			}
		} else {
			heap.add(input);
		}
		
	}

	
	
}
