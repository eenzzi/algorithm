n = int(input())

schedule = []
count = 1

for _ in range(n):
    line = list(map(int, input().split()))
    schedule.append(line)

schedule.sort(key=lambda x: (x[1], x[0]))

end_time = schedule[0][1]

for i in range(1, n):
    if schedule[i][0] >= end_time:
        count += 1
        end_time = schedule[i][1]

print(count)