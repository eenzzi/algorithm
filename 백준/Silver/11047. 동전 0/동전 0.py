n, k = map(int, input().split())
arr = []
count = 0

for i in range(n):
    arr.append(int(input()))

def min(K):
    global count
    for i in range(n - 1, -1, -1):
        if K >= arr[i]:
            count += (K // arr[i])
            K %= arr[i]



        if K == 0:
            return

min(k)

print(count)