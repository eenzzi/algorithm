import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    arr.append(int(input()))

def merge(left, right):
    i, j = 0, 0
    sorted_list = []

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sorted_list.append(left[i])
            i += 1
        else:
            sorted_list.append(right[j])
            j += 1

    while i < len(left):
        sorted_list.append(left[i])
        i += 1

    while j < len(right):
        sorted_list.append(right[j])
        j += 1

    return sorted_list

def merge_sort(unsorted_list):

    # 크기가 1 이하면 반환
    if len(unsorted_list) <= 1:
        return unsorted_list

    #리스트를 2분할
    mid = len(unsorted_list) // 2
    left = unsorted_list[:mid]
    right = unsorted_list[mid:]

    #계속 분할
    left_ = merge_sort(left)
    right_ = merge_sort(right)
    return merge(left_, right_)


result = merge_sort(arr)
for i in result:
    print(i)