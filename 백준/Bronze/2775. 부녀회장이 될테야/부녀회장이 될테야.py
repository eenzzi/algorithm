T = int(input())

graph = [[0] * 15 for _ in range(15)]

for i in range(T):
    k = int(input()) # k층 1 / 2
    n = int(input()) # n호 3 / 3

    for j in range(1, n+1):
        graph[0][j] = j

    #  1 1 / 1 2 / 1 3/ 2 1/ 2 2 / 2 3
    for j in range(1, k+1): # 1층, 2층 3층 ... k층
        for l in range(1, n+1): # 1호 2호 3호...n호
            graph[j][l] = graph[j-1][l] + graph[j][l-1]

    print(graph[k][n])