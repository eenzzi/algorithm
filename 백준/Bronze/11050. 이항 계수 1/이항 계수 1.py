import sys
sys.setrecursionlimit(10 ** 6)

n, k = map(int, input().split())

def factorial(n):
    if n > 0:
        return n * factorial(n - 1)
    else:
        return 1

numerator = factorial(n)
denominator = factorial(n - k) * factorial(k)

print(int(numerator / denominator))