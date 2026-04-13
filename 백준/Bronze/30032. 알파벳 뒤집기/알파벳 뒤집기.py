import sys

n, d = map(int, sys.stdin.readline().split())
arr = [list(sys.stdin.readline().strip()) for _ in range(n)]

if d == 1:
    for i in range(n):
        for k in range(n):
            if arr[i][k] == 'd':
                arr[i][k] = 'q'
            elif arr[i][k] == 'b':
                arr[i][k] = 'p'
            elif arr[i][k] == 'q':
                arr[i][k] = 'd'
            else:
                arr[i][k] = 'b'

else:
    for i in range(n):
        for k in range(n):
            if arr[i][k] == 'd':
                arr[i][k] = 'b'
            elif arr[i][k] == 'b':
                arr[i][k] = 'd'
            elif arr[i][k] == 'q':
                arr[i][k] = 'p'
            else:
                arr[i][k] = 'q'

for i in range(n):
    for k in range(n):
        print(arr[i][k], end='')
    print()