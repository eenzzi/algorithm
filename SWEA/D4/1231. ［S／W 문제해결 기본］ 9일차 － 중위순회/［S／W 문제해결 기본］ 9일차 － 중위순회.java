
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static String[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");

        	int N = Integer.parseInt(br.readLine());
        	tree = new String[N + 1];
        	
        	for(int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int V = Integer.parseInt(st.nextToken());
        		tree[V] = st.nextToken();
        	}
        	
        	inorder(1);
        	sb.append("\n");
        }
        
        wr.write(sb.toString());
        wr.flush();
        
	}
	
	private static void inorder(int V) {
		if (V >= tree.length || tree[V].equals("")) {
			return;
		}
		
		inorder(V * 2);
		sb.append(tree[V]);
		inorder(V * 2 + 1);
	}

}
