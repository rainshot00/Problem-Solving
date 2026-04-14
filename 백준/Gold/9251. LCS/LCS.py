import sys

str1 = sys.stdin.readline().strip()
str2 = sys.stdin.readline().strip()

dp = [[0] * (len(str2) + 1) for _ in range(len(str1) + 1)]

for i in range(1, len(str1) + 1):
    for k in range(1, len(str2) + 1):
        if str1[i - 1] == str2[k - 1]:
            dp[i][k] = dp[i - 1][k - 1] + 1
        else:
            dp[i][k] = max(dp[i - 1][k], dp[i][k - 1])

print(dp[len(str1)][len(str2)])