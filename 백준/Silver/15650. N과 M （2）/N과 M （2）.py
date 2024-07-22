n, m = map(int, input().split())
s = []

def dfs(start):

    if len(s) == m: #2
        print(' '.join(map(str, s)))
        return

    for i in range(start, n + 1): # 1, 2, 3, 4
        if i not in s:
            s.append(i) # s = 1, 2
            dfs(i + 1)
            s.pop()

dfs(1)