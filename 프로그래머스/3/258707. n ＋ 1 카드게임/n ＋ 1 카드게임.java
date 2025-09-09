import java.util.*;

class Solution {
    
    int[] cards;
    Set<Integer> myCards, additional;
    int n, coin;
    
    public int solution(int coin, int[] cards) {
        n = cards.length;
        this.cards = cards;
        this.coin = coin;
        myCards = new HashSet<>();
        additional = new HashSet<>();
        
        for (int i = 0; i < n / 3; i++) {
            myCards.add(cards[i]);
        }
        
        // 라운드 시작
        int idx = n / 3;
        int round = 0;
        while (true) {
            round++;
            if (idx >= n) break;
            
            // 두 장 뽑기
            additional.add(cards[idx++]);
            additional.add(cards[idx++]);
            
            boolean flag = false;

            // 바로 살 수 있는 경우
            for (int card : myCards) {
                if (myCards.contains(n + 1 - card)) {
                    myCards.remove(card);
                    myCards.remove(n + 1 - card);
                    flag = true;
                    break;
                }
            }
            
            // 한 개만 사는 경우
            if (!flag) {
                if (coin > 0) {
                    for (int card : myCards) {
                        int need = n + 1 - card;
                        if (additional.contains(need)) {
                            myCards.remove(card);
                            additional.remove(need);
                            --coin;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // 두 개 다 사는 경우
            if (!flag) {
                if (coin > 1) {
                    for (int card : additional) {
                        int need = n + 1 - card;
                        if (additional.contains(need)) {
                            additional.remove(card);
                            additional.remove(need);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if (!flag) break; 
        }
        
        return round;
    }
}