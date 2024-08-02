T = int(input())
 
for tc in range(1, T+1):
 
    word = input()
 
    result = word[::-1]
 
    print(f'#{tc}', end=' ')
    if word == result:
        print(1)
    else:
        print(0)