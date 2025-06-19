import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (String gem : gems) {
            set.add(gem);
        }
        
        int gemCnt = set.size();
        int start = 1;
        int end = 0;
        
        int[] answer = new int[2];
        answer[1] = gems.length;
        
        while (true) {
            if (map.size() == gemCnt) {
                // 조건 만족 → 최소 구간 갱신
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                }

                // 앞에서 하나 빼고 start 전진
                String gem = gems[start - 1];
                map.put(gem, map.get(gem) - 1);
                if (map.get(gem) == 0) map.remove(gem);

                start++;
            } else if (end == gems.length) {
                break;
            } else {
                // 조건 불만족 → 뒤에서 하나 넣고 end 전진
                String gem = gems[end];
                map.put(gem, map.getOrDefault(gem, 0) + 1);
                end++;
            }
        }
                
        return answer;
        
    }
}