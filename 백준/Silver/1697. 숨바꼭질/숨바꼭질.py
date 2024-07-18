from collections import deque

n, k = map(int, input().split())
MAX = 100001
visited = [0] * MAX


def bfs(v):
    q = deque([v])

    while q:
        v = q.popleft()

        if v == k:
            return visited[v]

        dx = [v - 1, v + 1, v * 2]

        for next_v in dx:
            if 0 <= next_v < MAX and not visited[next_v]:
                visited[next_v] = visited[v] + 1
                q.append(next_v)



print(bfs(n))