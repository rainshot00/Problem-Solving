import sys

t = int(sys.stdin.readline())

for _ in range(t):
    _ = sys.stdin.readline()
    r, c = map(int, sys.stdin.readline().split())
    arr = [list(sys.stdin.readline().strip()) for _ in range(r)]

    candy = 0
    for i in range(r):
        for k in range(c - 2):
            if arr[i][k] == '>' and arr[i][k + 1] == 'o' and arr[i][k + 2] == '<':
                candy += 1

    for i in range(r - 2):
        for k in range(c):
            if arr[i][k] == 'v' and arr[i + 1][k] == 'o' and arr[i + 2][k] == '^':
                candy += 1

    print(candy)