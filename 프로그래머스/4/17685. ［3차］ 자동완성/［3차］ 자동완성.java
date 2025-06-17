import java.util.*;

class Solution {
    
    class Trie {
        Map<Character, Trie> child;
        int childNum;
        
        Trie() {
            this.child = new HashMap<>();
            this.childNum = 0;
        }
        
        Trie add(char c) {
            
            Trie trie = child.computeIfAbsent(c, key -> new Trie());
            trie.childNum++;
            
            return trie;
        }
    }
    
    public int solution(String[] words) {
        
        Trie root = new Trie();
        
        for (String word : words) {
            
            Trie now = root; // 루트부터 시작
            
            for (int i = 0; i < word.length(); i++) {
                now = now.add(word.charAt(i));
            }
        }
        
        int answer = 0;
        
        for (String word : words) {
            Trie now = root;
            
            for (int i = 0; i < word.length(); i++) {
                now = now.child.get(word.charAt(i));
                answer++;
                
                if (now.childNum == 1) break;
            }
        }
        
        return answer;
    }
}