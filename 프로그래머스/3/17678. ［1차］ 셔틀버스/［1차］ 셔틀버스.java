import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int time = toMinutes("09:00"); // 540
        int peopleCnt = timetable.length;
        
        int[] table = new int[peopleCnt];
        
        for (int i = 0; i < peopleCnt; i++) {
            table[i] = toMinutes(timetable[i]);
        }
        
        Arrays.sort(table);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            time = 540 + i * t; // 셔틀 도착 시간

            int cnt = 0;
            
            for (int j = 0; j < peopleCnt; j++) {
                if (table[j] != 0 && canBoard(time, table[j])) {
                    cnt++;
                                    
                    if (i == n - 1 && cnt >= m) { // 꽉 채워진 경우
                        answer = table[j] - 1;
                        break;
                    }
                    
                    table[j] = 0;
                }

                
                if (cnt >= m) break;
                
                if (i == n - 1) { // 마지막까지 안 채워진 경우
                    answer = time;
                }
            }
        }
        
        return toTime(answer);
    }
    
    public boolean canBoard(int time, int arrive) {
        return time >= arrive;
    }
    
    public int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    public String toTime(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}