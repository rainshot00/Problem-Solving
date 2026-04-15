import sys

n, m = map(int, sys.stdin.readline().split())
days = [28, 29, 30, 31]

for day in days:
    if (n - 15) % day + 1 == m:
        print((n - 8) % day + 1)
        break