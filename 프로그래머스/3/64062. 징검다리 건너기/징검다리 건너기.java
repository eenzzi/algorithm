import java.util.*;

class Solution {
    
    int[] stones;
    int k;
    
    public int solution(int[] stones, int k) {
        
        this.stones = stones;
        this.k = k;
        
        int left = 1;
        int right = 200000000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (cross(mid)) { // 건널 수 있다면
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }

    public boolean cross(int value) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone < value) { // 0
                count++;
                
                if (count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
}