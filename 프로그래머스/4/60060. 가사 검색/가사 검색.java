import java.util.*;

class Solution {        

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
               
        Map<Integer, List<String>> map = new HashMap<>();
        Map<Integer, List<String>> revMap = new HashMap<>();
        
        // 맵에 단어들 저장 (key: 단어 길이)
        for (String word : words) {
            int len = word.length();
            
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
                revMap.put(len, new ArrayList<>());
            }
            
            map.get(len).add(word);
            revMap.get(len).add(reverse(word));
        }
        
        // 정렬
        for (int key : map.keySet()) {
            Collections.sort(map.get(key));
            Collections.sort(revMap.get(key));
        }
        
        // 이분 탐색
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            
            // map에 len 길이의 단어가 없으면 0
            if (!map.containsKey(len)) {
                answer[i] = 0;
                continue;
            }
            
            List<String> lenWords = map.get(len); // len 길이를 가지는 정렬된 단어 리스트
            
            // ?가 접두사일 때
            if (query.charAt(0) == '?') {
                lenWords = revMap.get(len);
                query = reverse(query);
            }
            
            // 이분탐색 
            String min = query.replace('?', 'a');
            String max = query.replace('?', 'z');
            int start = binarySearch(min, lenWords);
            int end = binarySearch(max, lenWords);
            answer[i] = end - start;
        }
    
        return answer;
    }
    
    private int binarySearch(String query, List<String> lenWords) {
        int start = 0;
        int end = lenWords.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (query.compareTo(lenWords.get(mid)) <= 0) { // query가 더 앞이면 -1
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}