import java.util.*;

class Solution {
    
    int size;
    int[] parent;
    String[] value;
    List<String> output;
    
    public String[] solution(String[] commands) {
        size = 51;
        parent = new int[size * size];
        value = new String[size * size];
        output = new ArrayList<>();
        
        // 초기화
        for (int i = 0; i < size * size; i++) {
            parent[i] = i;
        }
        
        for (String cmd : commands) {
            String[] parts = cmd.split(" ");
            
            if (parts[0].equals("UPDATE")) {
                if (parts.length == 4) { // UPDATE r c value
                    int r = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);
                    String v = parts[3];
                    update(r, c, v);
                } else { // UPDATE value1 value2
                    String v1 = parts[1];
                    String v2 = parts[2];
                    updateAll(v1, v2);
                }
            } else if (parts[0].equals("MERGE")) {
                int r1 = Integer.parseInt(parts[1]);
                int c1 = Integer.parseInt(parts[2]);
                int r2 = Integer.parseInt(parts[3]);
                int c2 = Integer.parseInt(parts[4]);
                merge(r1, c1, r2, c2);
            } else if (parts[0].equals("UNMERGE")) {               
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                unmerge(r, c);
            } else if (parts[0].equals("PRINT")) {
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                print(r, c);
            }
        }
        
        return output.toArray(new String[0]);
    }
    
    private int getId(int r, int c) {
        return r * size + c;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    private void update(int r, int c, String v) {
        int id = getId(r, c);
        int root = find(id);
        value[root] = v;
    }
    
    private void updateAll(String v1, String v2) {
        for (int i = 0; i < size * size; i++) {
            if (value[i] != null && value[i].equals(v1)) {
                value[i] = v2;
            }
        }
    }
    
    private void merge(int r1, int c1, int r2, int c2) {
        int id1 = getId(r1, c1);
        int id2 = getId(r2, c2);
        int root1 = find(id1);
        int root2 = find(id2);
        if (root1 == root2) return;
        
        // 값 우선순위 처리
        String newValue = (value[root1] != null) ? value[root1] : value[root2];
        
        union(root1, root2);
        int newRoot = find(root1);
        value[newRoot] = newValue;
    }
    
    private void unmerge(int r, int c) {
        int id = getId(r, c);
        int root = find(id);
        String keep = value[root];
        
        // root 그룹에 속한 모든 셀 분리
        List<Integer> members = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            if (find(i) == root) {
                members.add(i);
            }
        }
        
        for (int m : members) {
            parent[m] = m;
            value[m] = null;
        }
        
        // (r,c)에만 값 유지
        value[id] = keep;
    }
    
    private void print(int r, int c) {
        int id = getId(r, c);
        int root = find(id);
        if (value[root] == null) output.add("EMPTY");
        else output.add(value[root]);
    }
}