import sys
import heapq as hq

n = int(sys.stdin.readline().strip())
heap = []

for i in range(1, n + 1):
    x = int(sys.stdin.readline().strip())
    if x:
        hq.heappush(heap, (-x, x)) # 튜플을 저장해서 반대로 저장되도록
    else:
        if len(heap) == 0:
            print(0)
        else:
            print(hq.heappop(heap)[1])