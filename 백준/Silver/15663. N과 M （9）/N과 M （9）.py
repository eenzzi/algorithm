import sys
sys.setrecursionlimit(10 ** 6)

n, m = map(int, input().split())

s = []
arr = list(map(int, input().split()))
visited = [False] * n

arr.sort()

def dfs(start): #1 7 9 9

    prev = 0

    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(n):
        if arr[i] != prev and not visited[i]:
            s.append(arr[i])
            prev = arr[i]
            visited[i] = True

            dfs(start + 1)

            s.pop()
            visited[i] = False

dfs(0)