import sys

t = int(sys.stdin.readline())
answer = []

for testcase in range(1, t + 1):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))

    for i in range(1, n - 1):
        if arr[i] > (arr[i - 1] + arr[i + 1]) / 2:
            arr[i] = (arr[i - 1] + arr[i + 1]) / 2

    answer.append(f'Case #{testcase}: {arr[n - 2]}')

print('\n'.join(answer))