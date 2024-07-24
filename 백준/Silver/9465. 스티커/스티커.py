T = int(input())

def max_val(n, dp):

    if n > 1:
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]

    for i in range(2, n):
        dp[0][i] += max(dp[1][i - 1], dp[1][i - 2])
        dp[1][i] += max(dp[0][i - 1], dp[0][i - 2])

    print(max(dp[0][n - 1], dp[1][n - 1]))

for i in range(T):
    n = int(input())
    dp = [[] for _ in range(2)]
    dp[0] = list(map(int, input().split()))
    dp[1] = list(map(int, input().split()))

    max_val(n, dp)