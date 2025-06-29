import java.util.*;

class Solution {
    
    class Log {
        int start, end;
        
        public Log(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    List<Integer> timeList;
    
    public int solution(String[] lines) {
        List<Log> list = new ArrayList<>();
        timeList = new ArrayList<>();
        
        for (String line : lines) {
            Log log = toMillis(line);
            list.add(log);
        }
        
        int max = 0;
        for (int start : timeList) {
            int end = start + 999;
            int count = 0;
            
            for (Log log : list) {
                if (log.end >= start && log.start <= end) count++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
    
    public Log toMillis(String line) {
        String[] parts = line.split(" ");
        String time = parts[1];
        String duration = parts[2];
        
        String[] hms = time.split(":");
        int hour = Integer.parseInt(hms[0]);
        int min = Integer.parseInt(hms[1]);
        String[] secMillis = hms[2].split("\\.");
        int sec = Integer.parseInt(secMillis[0]);
        int ms = Integer.parseInt(secMillis[1]);
        
        int end = hour * 3600000 + min * 60000 + sec * 1000 + ms;
        
        double durationSec = Double.parseDouble(duration.replace("s", ""));
        int durationMs = (int)(durationSec * 1000);
        
        int start = end - durationMs + 1;
        
        if (!timeList.contains(start)) timeList.add(start);
        if (!timeList.contains(end)) timeList.add(end);
        
        return new Log(start, end);
    }
}