import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int peopleCnt = timetable.length;
        int[] times = new int[peopleCnt];
        
        for (int i = 0; i < peopleCnt; i++) {
            times[i] = toMinutes(timetable[i]);
        }
        
        Arrays.sort(times);
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int time = 540 + i * t;
            int count = 0;
            
            for (int j = 0; j < peopleCnt; j++) {
                if (times[j] != 0 && time >= times[j]) {
                    count++;
                    
                    if (i == n - 1 && count >= m) {
                        answer = times[j] - 1;
                        break;
                    }
                    
                    times[j] = 0;
                }
                
                if (count >= m) break;
                if (i == n - 1) answer = time;
            }
        }
        
        return toString(answer);
    }
    
    public int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    public String toString(int minutes) {
        int intHour = minutes / 60;
        int intMin = minutes - intHour * 60;
        String hour = ((intHour < 10) ? "0" : "") + String.valueOf(intHour);
        String min = ((intMin < 10) ? "0" : "") + String.valueOf(intMin);
        return hour + ":" + min;
    }
}