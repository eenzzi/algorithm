from collections import deque

n, m = map(int, input().split())

graph = [[] * (0) for i in range(m)]


for i in range(m):
    graph[i] = list(map(int, input().split()))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque()

# 토마토가 있는 곳 찾기
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            q.append((i, j))


def bfs():

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and ny >= 0 and nx < m and ny < n:
                if graph[nx][ny] == 0:
                    q.append((nx, ny))
                    graph[nx][ny] = graph[x][y] + 1

bfs()

day = 0

for row in graph:
    for tomato in row:
        if tomato == 0:
            print(-1)
            exit(0)
    day = max(day, max(row))

print(day - 1)