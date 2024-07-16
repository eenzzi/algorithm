dp = [0] * 1001

def test(n):

    if n == 1:
        return 1

    if n == 2:
        return 3

    if dp[n] != 0:
        return dp[n]

    dp[n] = test(n - 1) + test(n - 2) * 2

    return dp[n]


read = int(input())
print(test(read) % 10007)