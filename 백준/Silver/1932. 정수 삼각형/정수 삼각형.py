n = int(input())

graph = [[] for _ in range(n)]

for i in range(n):
    graph[i] = list(map(int, input().split()))


dp = [[0] * (i + 1) for i in range(n)]

for i in range(n):
    if i == 0:
        dp[i] = graph[i]
    else:
        for j in range(i + 1):
            if j == 0:
                dp[i][j] = dp[i - 1][j] + graph[i][j]
            elif j == i:
                dp[i][j] = dp[i - 1][j - 1] + graph[i][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + graph[i][j]


print(max(dp[n - 1]))