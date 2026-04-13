import sys

n, w, h = map(int, sys.stdin.readline().split())
len = (w ** 2 + h ** 2) ** 0.5
answer = []

for _ in range(n):
    match = int(sys.stdin.readline())

    if len >= match:
        answer.append('DA')
    else:
        answer.append('NE')

print('\n'.join(answer))