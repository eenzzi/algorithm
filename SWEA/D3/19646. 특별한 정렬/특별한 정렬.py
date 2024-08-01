T = int(input())
 
# Testcase 만큼 반복
for tc in range(1, T+1):
    n = int(input())
 
    arr = list(map(int, input().split()))
 
    for i in range(0, n-1, 2): # 0, 2, 4 ,...
        min_idx = i+1 # 최소값 인덱스
        max_idx = i # 최대값 인덱스
        for j in range(i+1, n): # max값 먼저 sort
            if arr[max_idx] < arr[j]:
                max_idx = j
 
        arr[i], arr[max_idx] = arr[max_idx], arr[i]
 
        for j in range(i+1, n): # min 값 sort
            if arr[min_idx] > arr[j]:
                min_idx = j
        if i+1 < n:
            arr[i+1], arr[min_idx] = arr[min_idx], arr[i+1]
 
    arr = ' '.join(map(str, arr[:10:]))
    print(f'#{tc} {arr}')