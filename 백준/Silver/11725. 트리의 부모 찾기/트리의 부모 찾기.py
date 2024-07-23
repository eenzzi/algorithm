import sys
sys.setrecursionlimit(10 ** 6)

n = int(sys.stdin.readline())

node = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)


for i in range(n - 1):
    a, b = map(int, input().split())
    node[a].append(b)
    node[b].append(a)

def dfs(purpose):

    for i in node[purpose]: # [6, 4]
        if visited[i] == 0:
            visited[i] = purpose # [0, 6, 0, 0, 0, 0, 1, 0, 0]
            dfs(i)

dfs(1)

for x in range(2, n+1):
    print(visited[x])