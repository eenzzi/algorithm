import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    st = new StringTokenizer(br.readLine());

	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    arr = new int[N];

	    st = new StringTokenizer(br.readLine());

	    for (int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }

	    Arrays.sort(arr);
	    
	    min();

	}

	private static void min() {

	    int max = arr[N - 1];
	    int min = 0;


	    while (min < max) {
	    	
	        int mid = (max + min) / 2;
	        long sum = 0;
	        
	    	for(int tree : arr) {
	    		if(tree > mid) {
	    			
	    			sum += (tree - mid);
	    		}
	    	}
	    	
	    	if(sum < M) {
	    		max = mid;
	    	} else {
	    		min = mid + 1;
	    	}
	    
	    }
	    


	    System.out.println(min - 1);

	}

}