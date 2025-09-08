import java.util.*;

class Solution {
    
    int n;
    int[][] dice;
    List<int[]> cases;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        this.dice = dice;
        cases = new ArrayList<>();        
        
        comb(n, n / 2, 0, new ArrayList<>()); // cases에 경우의 수 저장
        
        double maxRate = -1;
        int[] result = new int[n / 2];
        
        // 각 조합에 대한 승률 계산
        for (int[] aTeam : cases) {
            
            // B팀
            Set<Integer> remain = new HashSet<>();
            for (int i = 0; i < n; i++) remain.add(i);
            for (int a : aTeam) remain.remove(a);
            int[] bTeam = new int[n / 2];
            int idx = 0;
            for (int val : remain) bTeam[idx++] = val;
            
            // 합 리스트
            List<Integer> aSums = getSums(aTeam);
            List<Integer> bSums = getSums(bTeam);

            Collections.sort(aSums);
            Collections.sort(bSums);

            // 승리 횟수 계산
            int winCount = 0;
            for (int sum : aSums) {
                winCount += getCount(bSums, sum);
            }
            
            int total = aSums.size() * bSums.size();
            double winRate = (double) winCount / total;
            
            if (winRate > maxRate) {
                maxRate = winRate;
                for (int i = 0; i < aTeam.length; i++) result[i] = aTeam[i] + 1;
            }
        }
        
        return result;
    }
    
    public void comb(int n, int r, int start, List<Integer> list) {
        if (list.size() == r) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
            cases.add(arr);
            return;
        }
        
        for (int i = start; i < n; i++) {
            list.add(i);
            comb(n, r, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    
    private List<Integer> getSums(int[] selected) {
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        
        for (int idx : selected) {
            List<Integer> next = new ArrayList<>();
            for (int sum : sums) {
                for (int face : dice[idx]) {
                    next.add(sum + face);
                }
            }
            sums = next;
        }
        return sums;
    }
    
    // sum보다 작은 원소 개수 찾기 (이분 탐색)
    private int getCount(List<Integer> arr, int sum) {
        int l = 0;
        int r = arr.size();
        
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < sum) l = m + 1;
            else r = m;
        }
        return l;
    }
}