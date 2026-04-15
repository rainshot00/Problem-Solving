def combination(now, cnt, sumx1, sumy1, sumx2, sumy2):
    if now == n:
        global res
        res = min(res, (sumx1 - sumx2) ** 2 + (sumy1 - sumy2) ** 2)
        return

    if cnt == n // 2:
        combination(now + 1, cnt, sumx1, sumy1, sumx2 + arr[now][0], sumy2 + arr[now][1])
    elif now - cnt == n // 2:
        combination(now + 1, cnt + 1, sumx1 + arr[now][0], sumy1 + arr[now][1], sumx2, sumy2)
    else:
        combination(now + 1, cnt + 1, sumx1 + arr[now][0], sumy1 + arr[now][1], sumx2, sumy2)
        combination(now + 1, cnt, sumx1, sumy1, sumx2 + arr[now][0], sumy2 + arr[now][1])


t = int(input())
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    res = float('inf')
    combination(0, 0, 0, 0, 0, 0)

    answer.append(f'#{testcase} {res}')

print('\n'.join(answer))