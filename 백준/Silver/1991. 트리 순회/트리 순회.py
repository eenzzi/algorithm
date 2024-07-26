import sys
input = sys.stdin.readline

n = int(input())

tree = {}

for i in range(n):
    node, left, right = input().split()
    tree[node] = left, right # {'A' : (B, C)}

# 전위 순회
def pre_order(v):
    if v != '.':
       print(v, end='')
       pre_order(tree[v][0])
       pre_order(tree[v][1])

def in_order(v):
    if v != '.':
        in_order(tree[v][0])
        print(v, end='')
        in_order(tree[v][1])

def post_order(v):
    if v != '.':
        post_order(tree[v][0])
        post_order(tree[v][1])
        print(v, end='')

pre_order('A')
print()
in_order('A')
print()
post_order('A')