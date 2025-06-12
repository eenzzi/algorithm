import java.util.*;

class Solution {
    
    static class Node {
        int x, y, num;
        Node left, right;
        
        Node (int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    static int[][] answer;
    static int idxPre, idxPost;
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        answer = new int[2][nodeinfo.length];
        
        // node 등록
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            nodes.add(new Node(node[0], node[1], i + 1));
        }
        
        nodes.sort((a, b) -> {
            if (a.y != b.y) return b.y - a.y;
            return a.x - b.x;
        });
        
        // 부모 노드
        Node root = nodes.get(0);
        
        // 자식 등록
        for (int i = 1; i < nodeinfo.length; i++) {
            insert(root, nodes.get(i));
        }

        // 전위 순회
        pre(root);
        
        // 후위 순회
        post(root);
        
        return answer;
    }
    
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) { // 왼쪽
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else { // 오른쪽
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    private void pre(Node node) {
        if (node == null) return;
        answer[0][idxPre++] = node.num;
        pre(node.left);
        pre(node.right);
    }
    
    private void post(Node node) {
        if (node == null) return;
        post(node.left);
        post(node.right);
        answer[1][idxPost++] = node.num;
    }
}