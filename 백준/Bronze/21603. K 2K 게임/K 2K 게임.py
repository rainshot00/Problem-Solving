import sys

n, k = map(int, sys.stdin.readline().split())
answer = []

for i in range(1, n + 1):
    if i % 10 != k % 10 and i % 10 != 2 * k % 10:
        answer.append(i)

print(len(answer))
for ans in answer:
    print(ans, end=' ')