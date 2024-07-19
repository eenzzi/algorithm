import sys
from collections import deque
input = sys.stdin.readline

direction = [(-1,0),(1,0),(0,-1),(0,1)]
n,m = map(int,input().split())
arr = list(input().split() for _ in range(n))
visited = [[False]*m for _ in range(n)]
ans = [[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if arr[i][j]=="2":
            visited[i][j] = True
            q = deque([(i,j)])

while q:
    x, y = q.popleft()
    for dx, dy in direction:
        nx = x+dx
        ny = y+dy

        if 0<=nx<n and 0<=ny<m and arr[nx][ny]=="1" and not visited[nx][ny]:
            q.append((nx,ny))
            visited[nx][ny] = True
            ans[nx][ny]= ans[x][y]+1

for i in range(n):
    for j in range(m):
        if not visited[i][j] and arr[i][j]=="1":
            print(-1,end=" ")
        else:
            print(ans[i][j], end=" ")
    print()