n = int(input())

graph = [[] for _ in range(n)]

for i in range(n):
    graph[i] = list(map(int, input().split()))

min_val = 0
dp = [[0] * 3 for _ in range(n)]


for i in range(n):
    for j in range(3):
        if i == 0:
            dp[0][j] = graph[0][j]
        else:
            if j == 0:
                dp[i][0] = graph[i][0] + min(dp[i - 1][1], dp[i - 1][2])
            elif j == 1:
                dp[i][1] = graph[i][1] + min(dp[i - 1][0], dp[i - 1][2])
            else:
                dp[i][2] = graph[i][2] + min(dp[i - 1][0], dp[i - 1][1])

print(min(dp[n - 1]))