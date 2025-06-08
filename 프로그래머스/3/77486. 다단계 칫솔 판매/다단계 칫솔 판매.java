import java.util.*;

class Solution {
    
    static class Person {
        String name;
        Person parent;
        int val;
        
        public Person(String name, Person parent, int val) {
            this.name = name;
            this.parent = parent;
            this.val = val;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        int[] answer = new int[len];

        Map<String, Person> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            String name = enroll[i];
            map.put(name, new Person(name, null, 0));
        }
        
        // 부모 등록
        for (int i = 0; i < len; i++) {
            String parentName = referral[i];
            map.get(enroll[i]).parent = map.get(parentName);
        }
        
        // 수익 분배
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int val = amount[i] * 100;
            divide(map.get(name), val);
        }
        
        for (int i = 0; i < len; i++) {
            answer[i] = map.get(enroll[i]).val;
        }
        
        return answer;
    }
    
    private static void divide(Person person, int val) {
        if (person == null) return;        
        if (val <= 0) return;
        
        person.val += (val - val / 10);
        divide(person.parent, val / 10);
    }
}