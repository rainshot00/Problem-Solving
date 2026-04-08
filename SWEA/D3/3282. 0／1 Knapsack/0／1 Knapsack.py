t = int(input())
answer = []

for testcase in range(1, t + 1):
    n, k = map(int, input().split())
    arr = [[0, 0]]
    dp = [[0] * (k + 1) for _ in range(n + 1)]

    for _ in range(n):
        v, c = map(int, input().split())
        arr.append([v, c])

    for i in range(1, n + 1):
        for k in range(1, k + 1):
            if arr[i][0] > k:
                dp[i][k] = dp[i - 1][k]

            else:
                dp[i][k] = max(arr[i][1] + dp[i - 1][k - arr[i][0]], dp[i - 1][k])

    answer.append(f'#{testcase} {dp[n][k]}')

print('\n'.join(answer))