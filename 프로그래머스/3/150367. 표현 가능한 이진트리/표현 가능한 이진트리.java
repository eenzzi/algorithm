class Solution {
    /**
    * 일단 십진수 -> 이진수 바꾸고, 얘가 어디 트리 영역에 속하는지 확인
    * 개수는 1, 3, 7, 15... 이렇게 2a + 1 규칙으로 증가
    * 결국 부모가 있어야 자식이 있을 수 있으니까 루트부터 확인하면서 1인지 확인하는 문제
    **/
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            String binary = toBinary(numbers[i]);
            
            // 트리 크기 구하기
            int len = binary.length();
            int treeSize = 1;
            while (treeSize < len) {
                treeSize = treeSize * 2 + 1;
            }
            
            // 앞에 0 채우기
            StringBuilder sb = new StringBuilder();  
            for (int j = 0; j < treeSize - len; j++) {
                sb.append('0');
            }
            for (int j = 0; j < len; j++) {
                sb.append(binary.charAt(j));
            }
            binary = sb.toString();
            
            // 검사
            answer[i] = check(binary) ? 1 : 0;
        }
        return answer;
    }
    
    private String toBinary(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }
    
    private boolean check(String s) {
        if (s.length() == 1) return true;
        
        int mid = s.length() / 2;
        char root = s.charAt(mid);
        
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);
        
        // 부모가 0이면 자식은 1일 수 없음
        if (root == '0') {
            if (left.contains("1") || right.contains("1")) return false;
        }
        
        return check(left) && check(right);
    }
}