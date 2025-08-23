import java.util.*;

class Solution {
    
    class Node {
        int id;
        Node next, prev;
        
        Node (int id) {
            this.id = id;
        }
    }
        
    public String solution(int n, int k, String[] cmds) {
        Node[] nodes = new Node[n];
        Stack<Node> removed = new Stack<>();
        
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }
        
        Node now = nodes[k];
        
        for (String cmd : cmds) {
            if (cmd.startsWith("U")) {
                String[] arr = cmd.split(" ");
                int x = Integer.parseInt(arr[1]);
                while (x-- > 0) now = now.prev;
                
            } else if (cmd.startsWith("D")) {
                String[] arr = cmd.split(" ");
                int x = Integer.parseInt(arr[1]);
                while (x-- > 0) now = now.next;
                
            } else if (cmd.equals("C")) {
                removed.push(now); // 복구용
                
                if (now.prev != null) now.prev.next = now.next;
                if (now.next != null) now.next.prev = now.prev;
                    
                now = now.next != null ? now.next : now.prev;
                
            } else {
                Node node = removed.pop();
                
                if (node.prev != null) node.prev.next = node;
                if (node.next != null) node.next.prev = node;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] result = new boolean[n];
        Arrays.fill(result, true);
        for (Node node : removed) {
            result[node.id] = false;
        }
        
        for (int i = 0; i < n; i++) {
            sb.append(result[i] ? "O" : "X");
        }
        
        return sb.toString();
    }
}