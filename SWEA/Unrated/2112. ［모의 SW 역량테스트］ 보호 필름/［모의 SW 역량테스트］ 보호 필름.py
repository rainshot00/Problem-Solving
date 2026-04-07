def check():
    for x in range(w):
        cnt = 1
        for y in range(1, d):
            if arr[y][x] == arr[y - 1][x]:
                cnt += 1
            else:
                cnt = 1

            if cnt >= k:
                break

        if cnt < k:
            return False

    return True


def dfs(row, cnt):
    global res

    if cnt > res:
        return

    if row == d:
        if check():
            res = min(res, cnt)
        return

    now_row = arr[row]

    dfs(row + 1, cnt)

    arr[row] = [1] * w
    dfs(row + 1, cnt + 1)

    arr[row] = [0] * w
    dfs(row + 1, cnt + 1)

    arr[row] = now_row


t = int(input())
answer = []

for testcase in range(1, t + 1):
    d, w, k = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(d)]
    res = k

    # 일단 완탐
    dfs(0, 0)
    answer.append(f'#{testcase} {res}')

print('\n'.join(answer))
