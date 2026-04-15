import sys

n = int(sys.stdin.readline())
d, p = 0, 0

for _ in range(n):
    c = sys.stdin.readline().strip()

    if c == 'D':
        d += 1
    else:
        p += 1

    if abs(d - p) == 2:
        break

print(f'{d}:{p}')