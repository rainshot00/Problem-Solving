def calculate_time(p, s):
    arrive_time = []
    in_stair = []

    for person in p:
        arrive_time.append(abs(person[0] - s[0]) + abs(person[1] - s[1]) + 1)

    arrive_time.sort()

    for time in arrive_time:
        if len(in_stair) < 3:
            st = time
        else:
            st = max(time, in_stair[-3])

        in_stair.append(st + s[2])

    return max(in_stair) if in_stair else 0


t = int(input())
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    person = []
    stair = []
    res = float('inf')

    for i in range(n):
        for k in range(n):
            if arr[i][k] == 1:
                person.append((i, k))

            if arr[i][k] >= 2:
                stair.append((i, k, arr[i][k]))

    for i in range(1 << len(person)):
        st0, st1 = [], []

        for k in range(len(person)):
            if i & (1 << k) == 0:
                st0.append(person[k])
            else:
                st1.append(person[k])

        time = max(calculate_time(st0, stair[0]), calculate_time(st1, stair[1]))
        res = min(res, time)

    answer.append(f'#{testcase} {res}')

print('\n'.join(answer))