import sys


n, m = map(int, input().split())
dict = {}

for i in range(1, n + 1):
    temp = sys.stdin.readline().strip()
    dict[i] = temp
    dict[temp] = i

for i in range(m):
    item = sys.stdin.readline().strip()
    if item.isdigit():
        print(dict[int(item)])
    else:
        print(dict[item])