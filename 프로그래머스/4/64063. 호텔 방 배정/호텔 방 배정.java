import java.util.*;

class Solution {
    
    static Map<Long, Long> map;
    
    public long[] solution(long k, long[] room_number) {
        int N = room_number.length;
        long[] answer = new long[N];
        
        map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            long number = room_number[i];
            number = find(number);
            
            answer[i] = number;
        }
        
        return answer;
    }
    
    private long find(long number) {
        if (!map.containsKey(number)) {
            map.put(number, number + 1);
            return number;
        }
        
        long nextNumber = find(map.get(number));
        map.put(number, nextNumber + 1);
        return nextNumber;
    }
}