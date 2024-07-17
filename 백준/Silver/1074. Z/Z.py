n, r, c = map(int, input().split())

num = 0

def check(n, r, c): 

    global num

    standard = 2 ** (n - 1) 
    arr = (2 ** n) * (2 ** n) // 4 

    if r <= standard and c <= standard and n >= 0:
        num += 0
        check(n - 1, r, c)

    elif r <= standard and c > standard and n >= 0:
        num += arr
        check(n - 1, r, c - standard)

    elif r > standard and c <= standard and n >= 0:
        num += arr * 2
        check(n - 1, r - standard, c)

    elif r > standard and c > standard and n >= 0:
        num += arr * 3
        check(n - 1, r - standard, c - standard)

    return

check(n, r + 1, c + 1)

print(num)
