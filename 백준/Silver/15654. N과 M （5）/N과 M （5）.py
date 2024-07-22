n, m = map(int, input().split()) # 4 2

read = []
read = list(map(int, input().split())) # 1 7 8 9
read.sort()

s = []

def dfs():

    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(n): # 0, 1, 2, 3
        if read[i] not in s:
            s.append(read[i])
            dfs()
            s.pop()

dfs()