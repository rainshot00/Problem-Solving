import sys

n, k, c = map(int, sys.stdin.readline().split())
weight = list(map(int, sys.stdin.readline().split()))
weight.sort()

weight_cum = [weight[0]]
for i in range(1, n):
    weight_cum.append(weight_cum[-1] + weight[i])

thief = [sum(weight[:k])]
for i in range(1, n - k + 1):
    thief.append(thief[-1] - weight[i - 1] + weight[i + k - 1])

answer = [0] * (c + 1)
index = 0

for x in range(1, c + 1):
    if n - index <= k:
        answer[x] = thief[-1]
        continue

    if x >= weight_cum[index]:
        index += 1

    answer[x] = thief[index]

for i in range(1, c + 1):
    print(answer[i])