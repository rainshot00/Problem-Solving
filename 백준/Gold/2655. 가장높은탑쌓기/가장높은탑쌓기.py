import sys

n = int(sys.stdin.readline())
block = []

for i in range(n):
    a, h, w = map(int, sys.stdin.readline().split())
    block.append([a, h, w, i])

block.sort(key=lambda x: x[0], reverse=True)

dp = [-1] * n
top = [-1] * n

for i in range(n):
    dp[i] = block[i][1]

    for k in range(i):
        if block[i][2] < block[k][2]:
            if dp[i] < dp[k] + block[i][1]:
                dp[i] = dp[k] + block[i][1]
                top[i] = k

max_height = max(dp)
ans = []

idx = dp.index(max_height)
while idx != -1:
    ans.append(block[idx][3] + 1)
    idx = top[idx]

print(len(ans))
print('\n'.join(map(str, ans)))