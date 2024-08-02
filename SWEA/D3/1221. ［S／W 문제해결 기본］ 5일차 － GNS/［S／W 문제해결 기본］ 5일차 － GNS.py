T = int(input())
 
for tc in range(1, T+1):
 
    info = input()
 
    str_list = list(input().split())
    num_list = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    num_count = [0] * 10
 
    for num in str_list:
        for idx in range(10):
            if num == num_list[idx]:
                num_count[idx] += 1
                break
 
    print(f'#{tc}')
    for i in range(10):
        print(num_count[i] * (num_list[i] + ' '))