T = int(input())
 
for tc in range(1, T+1):
 
    stick = input()
    stack = []
    count = 0
 
    for i in range(len(stick)):
        if stick[i] == '(':
            stack.append('(')
        else: # ')' 일 때
            if stick[i-1] =='(': # 레이저일때
                stack.pop()
                count += len(stack)
            else:
                stack.pop() # 막대가 끝날 때
                count += 1
 
    print(f'#{tc} {count}')